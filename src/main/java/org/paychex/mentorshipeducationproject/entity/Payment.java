package org.paychex.mentorshipeducationproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;
import java.util.Objects;
//import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    private long paymentId;
    private long studentId;
    private long courseRegistrationId;
    private long mentorshipRegistrationId;
    private String transactionId;
    private double amount;
    @Temporal(TemporalType.DATE)
    private LocalDate payment_date;

    public Payment() {
    }

    public Payment(long paymentId, long studentId, long courseRegistrationId, long mentorshipRegistrationId, String transactionId, double amount, LocalDate payment_date) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.courseRegistrationId = courseRegistrationId;
        this.mentorshipRegistrationId = mentorshipRegistrationId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.payment_date = payment_date;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public void setCourseRegistrationId(long courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

    public long getMentorshipRegistrationId() {
        return mentorshipRegistrationId;
    }

    public void setMentorshipRegistrationId(long mentorshipRegistrationId) {
        this.mentorshipRegistrationId = mentorshipRegistrationId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return paymentId == payment.paymentId && studentId == payment.studentId && courseRegistrationId == payment.courseRegistrationId && mentorshipRegistrationId == payment.mentorshipRegistrationId && Double.compare(amount, payment.amount) == 0 && Objects.equals(transactionId, payment.transactionId) && Objects.equals(payment_date, payment.payment_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, studentId, courseRegistrationId, mentorshipRegistrationId, transactionId, amount, payment_date);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", studentId=" + studentId +
                ", courseRegistrationId=" + courseRegistrationId +
                ", mentorshipRegistrationId=" + mentorshipRegistrationId +
                ", transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", payment_date=" + payment_date +
                '}';
    }
}
