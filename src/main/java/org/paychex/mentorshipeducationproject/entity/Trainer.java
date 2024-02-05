package org.paychex.mentorshipeducationproject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table (name="trainer")
public class Trainer {

    @Id
    @Column(name = "trainer_id")
    private Long trainerId;

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

    @Column(name = "available_from")
    private LocalDate availableFrom;

    @Column(name = "cancellation_count")
    private Integer cancellationCount;

    @Column(name = "penalty")
    private Integer penalty;

    public Trainer(){

    }
    public Trainer( String firstName, String lastName, String userName, String contactNumber, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.password = password;
        this.email = email;
        this.availableFrom = LocalDate.now();
        this.cancellationCount = 0;
        this.penalty = 0;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", availableFrom=" + availableFrom +
                ", cancellationCount=" + cancellationCount +
                ", penalty=" + penalty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer trainer)) return false;
        return trainerId == trainer.trainerId && cancellationCount == trainer.cancellationCount && penalty == trainer.penalty && Objects.equals(firstName, trainer.firstName) && Objects.equals(lastName, trainer.lastName) && Objects.equals(userName, trainer.userName) && Objects.equals(contactNumber, trainer.contactNumber) && Objects.equals(password, trainer.password) && Objects.equals(email, trainer.email) && Objects.equals(availableFrom, trainer.availableFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, firstName, lastName, userName, contactNumber, password, email, availableFrom, cancellationCount, penalty);
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
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

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDate availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Integer getCancellationCount() {
        return cancellationCount;
    }

    public void setCancellationCount(Integer cancellationCount) {
        this.cancellationCount = cancellationCount;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

}
