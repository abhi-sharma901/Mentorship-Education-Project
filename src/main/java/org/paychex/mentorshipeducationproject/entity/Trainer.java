package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "trainer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id")
    private Long trainerId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "available_from")
    private LocalDate availableFrom;

    @Column(name = "cancellation_count")
    private Integer cancellationCount;

    @Column(name = "penalty")
    private Integer penalty;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDate createdDate;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Mentorship> mentorshipList = new HashSet<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Course> courseList = new HashSet<>();
}
