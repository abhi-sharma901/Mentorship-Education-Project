package org.paychex.mentorshipeducationproject.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    private Boolean isFullPaid;

    private Float totalBill;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student studentId;

    private Integer totalInstallment;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    private List<Installments> installementsList;
}
