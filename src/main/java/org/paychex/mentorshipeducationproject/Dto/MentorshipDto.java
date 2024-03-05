package org.paychex.mentorshipeducationproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.paychex.mentorshipeducationproject.utils.AvailabilityStatus;

import java.time.LocalDate;

/**
 * mentorshipDto is used to transfer data between controller and service
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipDto {
    private Long mentorshipId;
    private String mentorshipName;
    private String mentorshipDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private double mentorshipCost;
    private String imageUrl;
    private AvailabilityStatus status;
}
