package org.paychex.mentorshipeducationproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.paychex.mentorshipeducationproject.utils.AvailabilityStatus;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long courseId;
    private String courseName;
    private String courseDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double courseCost;
    private AvailabilityStatus status;
    private String imageUrl;
}
