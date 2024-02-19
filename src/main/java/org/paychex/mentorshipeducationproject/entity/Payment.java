package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Payment Entity Class
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payment")
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mentorship_id", referencedColumnName = "mentorship_id")
    @JsonIgnore
    private Mentorship mentorship;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @Column(name = "is_full_paid")
    private Boolean isFullPaid;

    @Column(name = "total_bill")
    private Double totalBill;

    @Column(name = "amount_due")
    private Double amountDue;

    @Column(name = "payment_date", columnDefinition = "DATE")
    private LocalDate paymentDate;

    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Installment>  installmentList = new HashSet<>();

    public Payment(Double paymentAmount, Boolean isFullPaid, Double totalBill, Double amountDue, LocalDate paymentDate) {
        this.paymentAmount = paymentAmount;
        this.isFullPaid = isFullPaid;
        this.totalBill = totalBill;
        this.amountDue = amountDue;
        this.paymentDate = paymentDate;
    }
}
