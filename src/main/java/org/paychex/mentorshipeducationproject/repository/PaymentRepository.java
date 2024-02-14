package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Payment;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    public Payment findPaymentByStudentAndCourse(Student student, Course course);

    public Payment findPaymentByStudentAndMentorship(Student student, Mentorship mentorship);

    @Modifying
    @Query("update Payment p set p.amountDue = :amountDue where p.paymentId = :paymentId")
    public int updateAmountDue(Double amountDue, Long paymentId);

    @Modifying
    @Query("update Payment p set p.paymentDate = :paymentDate where p.paymentId = :paymentId")
    public int updatePaymentDate(LocalDate paymentDate, Long paymentId);

    @Modifying
    @Query("update Payment p set p.isFullPaid = :fullPaid where p.paymentId = :paymentId")
    public int updateFullPaid(Boolean fullPaid, Long paymentId); //update full paid

}
