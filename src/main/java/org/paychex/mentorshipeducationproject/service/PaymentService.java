package org.paychex.mentorshipeducationproject.service;

import org.paychex.mentorshipeducationproject.entity.Payment;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.repository.PaymentRepository;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Payment makePayment(Payment p, Long id){
        Student s = new Student();
        s = studentRepository.findStudentByStudentId(id);
        p.setStudent(s);
        return paymentRepository.save(p);
    }
}
