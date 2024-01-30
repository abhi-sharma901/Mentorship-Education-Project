package org.paychex.mentorshipeducationproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;


@Entity
@Table(name ="student")
public class Student {
    @Id
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "pass_word")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "payment_due")
    private double paymentDue;

    @Column(name = "previous_courses")
    private  String previousCourses;

    @Column(name = "previous_mentorships")
    private String previousMentorships;

    public Student(){

    }

    public Student(long studentId, String firstName, String lastName, String email, String userName, String contactNumber, String password) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.paymentDue = 0;
        this.previousCourses = "";
        this.previousMentorships = "";
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return studentId == student.studentId && Double.compare(paymentDue, student.paymentDue) == 0 && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(userName, student.userName) && Objects.equals(contactNumber, student.contactNumber) && Objects.equals(password, student.password) && Objects.equals(email, student.email) && Objects.equals(previousCourses, student.previousCourses) && Objects.equals(previousMentorships, student.previousMentorships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, userName, contactNumber, password, email, paymentDue, previousCourses, previousMentorships);
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
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(double paymentDue) {
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

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }



}
