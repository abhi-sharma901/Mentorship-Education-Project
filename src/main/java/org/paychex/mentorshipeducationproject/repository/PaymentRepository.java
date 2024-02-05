package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

//    public Payment findPaymentByPaymentId(Long paymentId);
//    public List<Payment> findPaymentsByStudent(Long studentId);
//    public List<Payment> findPaymentsByCourse(Long courseId);
//    public List<Payment> findPaymentsByMentorship(Long mentorshipId);
}
