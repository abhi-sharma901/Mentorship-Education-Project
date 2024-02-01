package org.paychex.mentorshipeducationproject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Mentorship")
public class Mentorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  mentorshipId;
    @Column(name = "trainer_id")
    private long trainerId;
    @Column(name = "mentorship_name")
    private String mentorshipName;
    @Column(name = "mentorship_description")
    private String mentorshipDescription;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "mentorship_duration")
    private float mentorshipDuration;
    @Column(name = "mentorship_cost")
    private double mentorshipCost;

    public Mentorship () {}

    public Mentorship( long trainerId, String mentorshipName, String mentorshipDescription, LocalDate startDate, LocalDate endDate, float mentorshipDuration, double mentorshipCost) {
        this.mentorshipId = mentorshipId;
        this.trainerId = trainerId;
        this.mentorshipName = mentorshipName;
        this.mentorshipDescription = mentorshipDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mentorshipDuration = mentorshipDuration;
        this.mentorshipCost = mentorshipCost;
    }

    public long getMentorshipId() {
        return mentorshipId;
    }

    public void setMentorshipId(long mentorshipId) {
        this.mentorshipId = mentorshipId;
    }

    public long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(long trainerId) {
        this.trainerId = trainerId;
    }

    public String getMentorshipName() {
        return mentorshipName;
    }

    public void setMentorshipName(String mentorshipName) {
        this.mentorshipName = mentorshipName;
    }

    public String getMentorshipDescription() {
        return mentorshipDescription;
    }

    public void setMentorshipDescription(String mentorshipDescription) {
        this.mentorshipDescription = mentorshipDescription;
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

    public float getMentorshipDuration() {
        return mentorshipDuration;
    }

    public void setMentorshipDuration(float mentorshipDuration) {
        this.mentorshipDuration = mentorshipDuration;
    }

    public double getMentorshipCost() {
        return mentorshipCost;
    }

    public void setMentorshipCost(double mentorshipCost) {
        this.mentorshipCost = mentorshipCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentorship that = (Mentorship) o;
        return mentorshipId == that.mentorshipId && trainerId == that.trainerId && Float.compare(mentorshipDuration, that.mentorshipDuration) == 0 && Double.compare(mentorshipCost, that.mentorshipCost) == 0 && Objects.equals(mentorshipName, that.mentorshipName) && Objects.equals(mentorshipDescription, that.mentorshipDescription) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorshipId, trainerId, mentorshipName, mentorshipDescription, startDate, endDate, mentorshipDuration, mentorshipCost);
    }

    @Override
    public String toString() {
        return "Mentorship{" +
                "mentorshipId=" + mentorshipId +
                ", trainerId=" + trainerId +
                ", mentorshipName='" + mentorshipName + '\'' +
                ", mentorshipDescription='" + mentorshipDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", mentorshipDuration=" + mentorshipDuration +
                ", mentorshipCost=" + mentorshipCost +
                '}';
    }
}

