package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.paychex.mentorshipeducationproject.utils.CourseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

//    @Column(name="trainer_id", nullable = false)
//    private Long  trainerId;

    @Column(name="course_name", nullable = false)
    private String courseName;

    @Column(name="course_description", nullable = false)
    private String courseDescription;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name="course_cost")
    private Double courseCost;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="course_status")
    private Boolean status;

    @JsonIgnore
    @ManyToMany(mappedBy = "course",cascade=CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course", cascade=CascadeType.ALL)
    private List<Payment> paymentList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
}
