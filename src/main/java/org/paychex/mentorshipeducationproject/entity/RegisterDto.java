package org.paychex.mentorshipeducationproject.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
