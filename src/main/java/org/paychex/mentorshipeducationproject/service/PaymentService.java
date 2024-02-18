package org.paychex.mentorshipeducationproject.service;

import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.Dto.PaymentDto;
import org.paychex.mentorshipeducationproject.constant.GlobalConstants;
import org.paychex.mentorshipeducationproject.entity.*;
import org.paychex.mentorshipeducationproject.exceptions.AlreadyEnrolledException;
import org.paychex.mentorshipeducationproject.exceptions.CourseNotAvailableException;
import org.paychex.mentorshipeducationproject.exceptions.PaymentMismatchException;
import org.paychex.mentorshipeducationproject.mapper.PaymentMapper;
import org.paychex.mentorshipeducationproject.repository.*;
import org.paychex.mentorshipeducationproject.utils.AvailabilityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static org.paychex.mentorshipeducationproject.constant.GlobalConstants.NO_OF_INSTALLMENTS;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MentorshipRepository mentorshipRepository;

    @Autowired
    private InstallmentRepository installmentRepository;

    @Transactional
    public Payment makePaymentForCourse(Payment p, Long sid, Long cid){

        Student student = studentRepository.findStudentByStudentId(sid);
        Course course = courseRepository.findCourseByCourseId(cid);
        if(course.getStudents().size() == GlobalConstants.MAX_NO_OF_STUDENTS){
            throw new CourseNotAvailableException("Course is full");
        }
        if(course.getStatus() == AvailabilityStatus.NOT_AVAILABLE){
            throw new CourseNotAvailableException();
        }
        if(!p.getIsFullPaid())
        {
            if(p.getPaymentAmount() != course.getCourseCost()/NO_OF_INSTALLMENTS){
                throw new PaymentMismatchException("Installment amount not equal to course cost");
            }
            return makePaymentWithInstallment(p,sid,cid,null);
        }
        if(student.getCourses().contains(course) && course.getStudents().contains(student)){
            throw new AlreadyEnrolledException("Course Already enrolled");
        }
        p.setStudent(student);
        student.getPaymentList().add(p);
        p.setCourse(course);
        course.getPaymentList().add(p);
        p.setTotalBill(course.getCourseCost());
        p.setAmountDue(0.0);

        // throw error if amount is not equal to
        // course cost or check if payment isFullPaid i false then active makePaymentWithInstallment

        if(!Objects.equals(p.getPaymentAmount(), course.getCourseCost())){
            throw new  PaymentMismatchException("Amount not equal to course cost");
        }
        p.setPaymentDate(LocalDate.now());

        student.getCourse().add(course);
        course.getStudents().add(student);

        return paymentRepository.save(p);
    }

    @Transactional
    public Payment makePaymentForMentorship(Payment p, Long sid, Long mid) {
        Student student = studentRepository.findStudentByStudentId(sid);
        Mentorship mentorship = mentorshipRepository.findMentorshipByMentorshipId(mid);
        if (mentorship.getStatus() == AvailabilityStatus.NOT_AVAILABLE) {
            throw new RuntimeException("Mentorship Not Available");
        }
        if (!p.getIsFullPaid()) {
            if (p.getPaymentAmount() != mentorship.getMentorshipCost() / NO_OF_INSTALLMENTS) {
                throw new PaymentMismatchException("Installment Amount not correct");
            }
            return makePaymentWithInstallment(p, sid, null, mid);
        }
        if(student.getMentorshipList().contains(mentorship) && Objects.equals(mentorship.getStudent(), student)){
            throw new AlreadyEnrolledException("Mentorship Already enrolled");
        }
        p.setStudent(student);
        student.getPaymentList().add(p);
        p.setMentorship(mentorship);
        mentorship.setStudent(student);
        mentorship.setStatus(AvailabilityStatus.NOT_AVAILABLE);
        p.setTotalBill(mentorship.getMentorshipCost());
        p.setAmountDue(0.0);

        // throw error if amount is not equal to
        // course cost or check if payment isFullPaid i false then active makePaymentWithInstallment

        if (!Objects.equals(p.getPaymentAmount(), mentorship.getMentorshipCost())) {
            throw new PaymentMismatchException("Amount not equal to Mentorship cost");
        }
        p.setAmountDue(null);
        p.setPaymentDate(LocalDate.now());
        return paymentRepository.save(p);
    }

    @Transactional
    public Payment makePaymentWithInstallment(Payment payment, Long sid, Long cid, Long mid){
        Student student = studentRepository.findStudentByStudentId(sid);
        Course course = cid == null ? null
                : courseRepository.findCourseByCourseId(cid);
        Mentorship mentorship = mid == null ? null
                : mentorshipRepository.findMentorshipByMentorshipId(mid);
        Payment existingPayment = course == null
                ? paymentRepository.findPaymentByStudentAndMentorship(student,mentorship)
                : paymentRepository.findPaymentByStudentAndCourse(student,course);


        if(Objects.isNull(existingPayment)){
            if(course != null && mentorship == null){
                payment.setTotalBill(course.getCourseCost());
                payment.setAmountDue(course.getCourseCost()
                        - payment.getPaymentAmount());
                payment.setCourse(course);
                student.getCourse().add(course);
                course.getStudents().add(student);
            }

            if(course == null && mentorship != null){
                payment.setTotalBill(mentorship.getMentorshipCost());
                payment.setAmountDue(mentorship.getMentorshipCost()
                        - payment.getPaymentAmount());
                payment.setMentorship(mentorship);
                student.getMentorshipList().add(mentorship);
                mentorship.setStudent(student);
            }

            payment.setPaymentDate(LocalDate.now());
            payment.setStudent(student);

            Installment installment = new Installment(payment.getPaymentAmount(), LocalDate.now());
            installment.setPayment(payment);

//            Set<Installment> installmentList = new HashSet<>();
//            installmentList.add(installment);
//            payment.setInstallmentList(installmentList);
            payment.getInstallmentList().add(installment);
            student.getPaymentList().add(payment);

            installmentRepository.save(installment);
            return paymentRepository.save(payment);
        }

        Set<Installment> installmentList = existingPayment.getInstallmentList();
        Installment installment = new Installment(payment.getPaymentAmount(), LocalDate.now());
        installment.setPayment(existingPayment);
        existingPayment.setInstallmentList(installmentList);

        installmentRepository.save(installment);

        Long id = existingPayment.getPaymentId();

        int ua =updateAmountDue(existingPayment.getAmountDue() -
                existingPayment.getPaymentAmount(), id);

        int ud =updatePaymentDate(LocalDate.now(),id);

        if(existingPayment.getInstallmentList().size() == NO_OF_INSTALLMENTS){
            int uf=updateFullPaid(true, id); //update full paid to true
        }
        payment.getInstallmentList().add(installment);
        return payment;

    }

    public List<PaymentDto> getPaymentsByStudent(Long studentId){
        Student student = studentRepository.findStudentByStudentId(studentId);
        List<PaymentDto> payments = new ArrayList<>();
        for(Payment p : student.getPaymentList()){
            payments.add(PaymentMapper.mapToPaymentDto(p));
        }
        return payments;
    }

    @Transactional
    public int updateAmountDue(Double amountDue, Long id){
        return paymentRepository.updateAmountDue(amountDue, id);
    }

    @Transactional
    public int updatePaymentDate(LocalDate paymentDate, Long id ){
        return paymentRepository.updatePaymentDate(paymentDate,id);
    }

    @Transactional
    public int updateFullPaid(Boolean fullPaid, Long id){
        return paymentRepository.updateFullPaid(fullPaid, id);
    }
}
