package org.paychex.mentorshipeducationproject.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.paychex.mentorshipeducationproject.utils.UserType;

/**
 * Register Dto to register
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String email;
    private String password;
    private UserType usertype;
     private String firstName;
     private String lastName;
     private String contactNumber;

}
