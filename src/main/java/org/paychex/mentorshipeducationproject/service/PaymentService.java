package org.paychex.mentorshipeducationproject.service;

import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Installment;
import org.paychex.mentorshipeducationproject.entity.Payment;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.paychex.mentorshipeducationproject.repository.InstallmentRepository;
import org.paychex.mentorshipeducationproject.repository.PaymentRepository;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private InstallmentRepository installmentRepository;

    @Transactional
    public Payment makePaymentForCourse(Payment p, Long sid, Long cid){

        Student student = studentRepository.findStudentByStudentId(sid);
        Course course = courseRepository.findCourseByCourseId(cid);
        if(!p.getIsFullPaid())
        {
            if(p.getPaymentAmount() != course.getCourseCost()/NO_OF_INSTALLMENTS){
                throw new RuntimeException("Amount is not equal to course cost");
            }
            return makePaymentWithInstallment(p,sid,cid);
        }
        p.setStudent(student);
        p.setCourse(course);
        p.setTotalBill(course.getCourseCost());

        // throw error if amount is not equal to
        // course cost or check if payment isFullPaid i false then active makePaymentWithInstallment

        if(!Objects.equals(p.getPaymentAmount(), course.getCourseCost())){
            throw new RuntimeException("Amount is not equal to course cost");
        }
        p.setAmountDue(null);
        p.setPaymentDate(LocalDate.now());
        return paymentRepository.save(p);
    }

    @Transactional
    public Payment makePaymentWithInstallment(Payment payment, Long sid, Long cid){
        Student student = studentRepository.findStudentByStudentId(sid);
        Course course = courseRepository.findCourseByCourseId(cid);
        Payment existingPayment = paymentRepository.findPaymentByStudentAndCourse(student,course);

        if(Objects.isNull(existingPayment)){
            payment.setTotalBill(course.getCourseCost());
            payment.setAmountDue(course.getCourseCost() - payment.getPaymentAmount());
            payment.setPaymentDate(LocalDate.now());
            payment.setStudent(student);
            payment.setCourse(course);

            Installment installment = new Installment(payment.getPaymentAmount(), LocalDate.now());
            installment.setPayment(payment);

            Set<Installment> installmentList = new HashSet<>();
            installmentList.add(installment);
            payment.setInstallmentList(installmentList);

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
        return payment;

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
