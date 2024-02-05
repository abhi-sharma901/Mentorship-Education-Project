package org.paychex.mentorshipeducationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "username", nullable = false, unique = true)
    private String userName;
    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;
    @Column(name = "pass_word", nullable = false, unique = true)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "payment_due")
    private Double paymentDue;
    @Column(name = "previous_courses")
    private String previousCourses;
    @Column(name = "previous_mentorships")
    private String previousMentorships;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> course;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_mentorship",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "mentorship_id"))
    private Set<Mentorship> mentorship;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Payment> paymentList;

    public Student() {
    }

    public Student(String firstName, String lastName, String userName, String contactNumber, String password,
                   String email, Double paymentDue, String previousCourses, String previousMentorships,
                   Set<Course> course, Set<Mentorship> mentorship, Set<Payment> paymentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.password = password;
        this.email = email;
        this.paymentDue = paymentDue;
        this.previousCourses = previousCourses;
        this.previousMentorships = previousMentorships;
        this.course = course;
        this.mentorship = mentorship;
        this.paymentList = paymentList;
    }

    public Set<Mentorship> getMentorship() {
        return mentorship;
    }

    public void setMentorship(Set<Mentorship> mentorship) {
        this.mentorship = mentorship;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Double paymentDue) {
        this.paymentDue = paymentDue;
    }

    public String getPreviousCourses() {
        return previousCourses;
    }

    public void setPreviousCourses(String previousCourses) {
        this.previousCourses = previousCourses;
    }

    public String getPreviousMentorships() {
        return previousMentorships;
    }

    public void setPreviousMentorships(String previousMentorships) {
        this.previousMentorships = previousMentorships;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public Set<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Set<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", paymentDue=" + paymentDue +
                ", previousCourses='" + previousCourses + '\'' +
                ", previousMentorships='" + previousMentorships + '\'' +
                ", course=" + course.toString()
                +
                ", mentorship=" + mentorship.toString() +
                ", paymentList=" + paymentList.toString() +
                '}';
    }
}
