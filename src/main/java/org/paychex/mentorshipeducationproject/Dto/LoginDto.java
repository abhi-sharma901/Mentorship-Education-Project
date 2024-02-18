package org.paychex.mentorshipeducationproject.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.paychex.mentorshipeducationproject.entity.UserType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String email;
    private String password;
    private UserType usertype;

}
