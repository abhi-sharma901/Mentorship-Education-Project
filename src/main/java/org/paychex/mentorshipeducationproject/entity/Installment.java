package org.paychex.mentorshipeducationproject.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "installment")
@Entity
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long installmentId;
    @Column(name = "installmentAmount", nullable = false)
    private Double installmentAmount;
    @Column(name = "installment_date", columnDefinition = "DATE", nullable = false)
    private LocalDate installmentDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    public Installment() {
    }

    public Installment(Double installmentAmount, LocalDate installmentDate) {
        this.installmentAmount = installmentAmount;
        this.installmentDate = installmentDate;
    }

    public Long getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(Long installmentId) {
        this.installmentId = installmentId;
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public LocalDate getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(LocalDate installmentDate) {
        this.installmentDate = installmentDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Installment that)) return false;
        return Objects.equals(installmentId, that.installmentId) && Objects.equals(installmentAmount, that.installmentAmount)
                && Objects.equals(installmentDate, that.installmentDate) && Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(installmentId, installmentAmount, installmentDate, payment);
    }

    @Override
    public String toString() {
        return "Installment{" +
                "installmentId=" + installmentId +
                ", installmentAmount=" + installmentAmount +
                ", installmentDate=" + installmentDate +
                ", payment=" + payment +
                '}';
    }
}
