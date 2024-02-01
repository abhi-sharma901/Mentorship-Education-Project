package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "student")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "pass_word")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "payment_due")
    private double paymentDue;

    @Column(name = "previous_courses")
    private String previousCourses;

    @Column(name = "previous_mentorships")
    private String previousMentorships;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> course;


    @OneToMany(mappedBy = "studentId")
    private List<Payment> paymentList;

    public Student() {

    }
}
