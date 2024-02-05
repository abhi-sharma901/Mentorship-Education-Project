package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.paychex.mentorshipeducationproject.utils.CourseStatus;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @Column(name="trainer_id", nullable = false)
    private Long  trainerId;
    @Column(name="course_name", nullable = false)
    private String courseName;
    @Column(name="course_description", nullable = false)
    private String courseDescription;
    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;
    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;
    @Column(name="course_cost")
    private Double courseCost;
    @Column(name="course_status", nullable = false, columnDefinition = "varchar(15) default 'NOT_STARTED' ")
    @Enumerated(EnumType.STRING)
    private CourseStatus status;
    @JsonIgnore
    @ManyToMany(mappedBy = "course",cascade=CascadeType.ALL)
    private Set<Student> students;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course", cascade=CascadeType.ALL)
    private Set<Payment> paymentList;

    public Course() {
    }

    public Course(Long trainerId, String courseName, String courseDescription, LocalDate startDate, LocalDate endDate, Double courseCost, CourseStatus status, Set<Student> students, Set<Payment> paymentList) {
        this.trainerId = trainerId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseCost = courseCost;
        this.status = status;
        this.students = students;
        this.paymentList = paymentList;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Set<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(courseId, course.courseId) && Objects.equals(trainerId, course.trainerId) && Objects.equals(courseName, course.courseName) && Objects.equals(courseDescription, course.courseDescription) && Objects.equals(startDate, course.startDate) && Objects.equals(endDate, course.endDate) && Objects.equals(courseCost, course.courseCost) && status == course.status && Objects.equals(students, course.students) && Objects.equals(paymentList, course.paymentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, trainerId, courseName, courseDescription, startDate, endDate, courseCost, status, students, paymentList);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", trainerId=" + trainerId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseCost=" + courseCost +
                ", status=" + status +
                ", students=" + students +
                ", paymentList=" + paymentList +
                '}';
    }
}
