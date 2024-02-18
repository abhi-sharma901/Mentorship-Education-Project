package org.paychex.mentorshipeducationproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto {
    private Long trainerId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate availableFrom;
    private Integer cancellationCount;
    private Integer penalty;
    private Boolean isActive;
}
