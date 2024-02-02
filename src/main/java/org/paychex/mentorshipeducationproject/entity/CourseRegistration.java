package org.paychex.mentorshipeducationproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.paychex.mentorshipeducationproject.utils.CourseStatus;

import java.util.Objects;

@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseRegistrationId;
    private long studentId;
    private long courseId;
    private CourseStatus status;
    private boolean installment;
    private int installmentsMade;

    public CourseRegistration() {
    }

    public long getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public void setCourseRegistrationId(long courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public boolean getInstallment() {
        return installment;
    }

    public void setInstallment(boolean installment) {
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
        if (!(o instanceof CourseRegistration that)) return false;
        return courseRegistrationId == that.courseRegistrationId && studentId == that.studentId && courseId == that.courseId && Boolean.compare(installment, that.installment) == 0 && installmentsMade == that.installmentsMade && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRegistrationId, studentId, courseId, status, installment, installmentsMade);
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "courseRegistrationId=" + courseRegistrationId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", status='" + status + '\'' +
                ", installment=" + installment +
                ", installmentsMade=" + installmentsMade +
                '}';
    }
}
