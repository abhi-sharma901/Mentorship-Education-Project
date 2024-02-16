package org.paychex.mentorshipeducationproject.security;


import org.paychex.mentorshipeducationproject.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(
                        auth->
                                auth
                                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                                        .requestMatchers("api/register").permitAll()
                                        .requestMatchers("onlineMentorship/guest/**").permitAll()
                                        .requestMatchers("api/studentRegister").permitAll()
                                        .requestMatchers("api/trainerRegister").permitAll()
                                        .requestMatchers("api/login").permitAll()
                                        .requestMatchers("api/currentUser").hasAnyAuthority(UserType.TRAINER.toString(),UserType.STUDENT.toString(),UserType.ADMIN.toString())
                                        .requestMatchers("onlineMentorship/student/**").hasAnyAuthority(UserType.STUDENT.toString(),UserType.ADMIN.toString())
                                        .requestMatchers("onlineMentorship/trainer/**").hasAnyAuthority(UserType.TRAINER.toString(),UserType.ADMIN.toString())
                                        .anyRequest().authenticated()
                                        )
                .exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthEntryPoint))

                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}
