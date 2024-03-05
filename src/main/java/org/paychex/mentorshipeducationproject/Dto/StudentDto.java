package org.paychex.mentorshipeducationproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Student Dto to create student
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean status;
}
