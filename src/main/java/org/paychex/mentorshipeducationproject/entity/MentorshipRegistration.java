package org.paychex.mentorshipeducationproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class MentorshipRegistration {
    @Id
    private long mentorshipRegistrationId;
    private long studentId;
    private long mentorshipId;
    private String status;//PENDING, REGISTERED
    private double installment;
    private int installmentsMade;

    public MentorshipRegistration() {
    }

    public long getMentorshipRegistrationId() {
        return mentorshipRegistrationId;
    }

    public void setMentorshipRegistrationId(long mentorshipRegistrationId) {
        this.mentorshipRegistrationId = mentorshipRegistrationId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getMentorshipId() {
        return mentorshipId;
    }

    public void setMentorshipId(long mentorshipId) {
        this.mentorshipId = mentorshipId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getInstallment() {
        return installment;
    }

    public void setInstallment(double installment) {
        this.installment = installment;
    }

    public int getInstallmentsMade() {
        return installmentsMade;
    }

    public void setInstallmentsMade(int installmentsMade) {
        this.installmentsMade = installmentsMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MentorshipRegistration that)) return false;
        return mentorshipRegistrationId == that.mentorshipRegistrationId && studentId == that.studentId && mentorshipId == that.mentorshipId && Double.compare(installment, that.installment) == 0 && installmentsMade == that.installmentsMade && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorshipRegistrationId, studentId, mentorshipId, status, installment, installmentsMade);
    }

    @Override
    public String toString() {
        return "MentorshipRegistration{" +
                "mentorshipRegistrationId=" + mentorshipRegistrationId +
                ", studentId=" + studentId +
                ", mentorshipId=" + mentorshipId +
                ", status='" + status + '\'' +
                ", installment=" + installment +
                ", installmentsMade=" + installmentsMade +
                '}';
    }
}
