package org.paychex.mentorshipeducationproject.entity;

import lombok.*;

/**
 * Jwt Entity for JWT Token
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private String token;
    private String email;
}
