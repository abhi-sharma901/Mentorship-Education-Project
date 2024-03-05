package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.paychex.mentorshipeducationproject.utils.AvailabilityStatus;


import java.time.LocalDate;
import java.util.Set;

/**
 * Mentorship Entity Class
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "mentorship")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mentorship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorship_id")
    private Long  mentorshipId;

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

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonIgnore
    @OneToOne(mappedBy = "mentorship")
    private Payment payment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
}

