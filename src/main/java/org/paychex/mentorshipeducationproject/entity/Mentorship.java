package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.paychex.mentorshipeducationproject.utils.MentorshipStatus;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "mentorship")
public class Mentorship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorship_id")
    private Long  mentorshipId;

//    @Column(name = "trainer_id", nullable = false)
//    private Long trainerId;

    @Column(name = "mentorship_name", nullable = false)
    private String mentorshipName;

    @Column(name = "mentorship_description", nullable = false)
    private String mentorshipDescription;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "mentorship_cost", nullable = false)
    private double mentorshipCost;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MentorshipStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "mentorship", cascade=CascadeType.ALL)
    private Set<Payment> paymentList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

}

