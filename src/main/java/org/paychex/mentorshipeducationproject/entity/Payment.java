package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mentorship_id")
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
    @OneToMany(mappedBy = "payment",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Installment> installmentList;

    public Payment() {
    }

    public Payment(/*Student student, Course course, Mentorship mentorship,*/ Double paymentAmount,
                   Boolean isFullPaid, Double totalBill, Double amountDue, LocalDate paymentDate,
                   Set<Installment> installmentList) {
//        this.student = student;
//        this.course = course;
//        this.mentorship = mentorship;
        this.paymentAmount = paymentAmount;
        this.isFullPaid = isFullPaid;
        this.totalBill = totalBill;
        this.amountDue = amountDue;
        this.paymentDate = paymentDate;
        this.installmentList = installmentList;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Mentorship getMentorship() {
        return mentorship;
    }

    public void setMentorship(Mentorship mentorship) {
        this.mentorship = mentorship;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Boolean getFullPaid() {
        return isFullPaid;
    }

    public void setFullPaid(Boolean fullPaid) {
        isFullPaid = fullPaid;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public Double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Double amountDue) {
        this.amountDue = amountDue;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Set<Installment> getInstallmentList() {
        return installmentList;
    }

    public void setInstallmentList(Set<Installment> installmentList) {
        this.installmentList = installmentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(paymentId, payment.paymentId) && Objects.equals(student, payment.student)
                && Objects.equals(course, payment.course) && Objects.equals(mentorship, payment.mentorship)
                && Objects.equals(paymentAmount, payment.paymentAmount) && Objects.equals(isFullPaid, payment.isFullPaid)
                && Objects.equals(totalBill, payment.totalBill) && Objects.equals(amountDue, payment.amountDue)
                && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(installmentList, payment.installmentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, student, course, mentorship, paymentAmount,
                isFullPaid, totalBill, amountDue, paymentDate, installmentList);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", student=" + student +
                ", course=" + course +
                ", mentorship=" + mentorship +
                ", paymentAmount=" + paymentAmount +
                ", isFullPaid=" + isFullPaid +
                ", totalBill=" + totalBill +
                ", amountDue=" + amountDue +
                ", paymentDate=" + paymentDate +
                ", installmentList=" + installmentList +
                '}';
    }
}
