package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long courseId;
    @Column(name="trainer_id")
    private long  trainerId;
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_description")
    private  String CourseDescription;
    @Column(name="course_duration")
    private float courseDuration;
    @Column(name="course_cost")
    private  double courseCost;
    @Column(name="course_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(mappedBy = "course",cascade=CascadeType.ALL)
    private Set<Student> student;


    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    private Payment payment;


    public enum Status {
        active,
        inactive
    }
}
