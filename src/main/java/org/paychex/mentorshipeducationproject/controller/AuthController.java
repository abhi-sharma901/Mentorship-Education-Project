package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.Dto.LoginDto;
import org.paychex.mentorshipeducationproject.Dto.RegisterDto;
import org.paychex.mentorshipeducationproject.entity.*;
import org.paychex.mentorshipeducationproject.security.CustomUserDetailsService;
import org.paychex.mentorshipeducationproject.security.JwtGenerator;
import org.paychex.mentorshipeducationproject.service.AdminService;
import org.paychex.mentorshipeducationproject.service.RegisterService;
import org.paychex.mentorshipeducationproject.service.StudentService;
import org.paychex.mentorshipeducationproject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * It has Controllers used to log in and register with authentication token
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Bean
    public Admin admin(){
        Admin admin = new Admin();
        if(!adminService.checkAdminExistsByEmail(admin.getEmail()))
        {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            adminService.createAdmin(admin);
        }
        return admin;
    }

    /**
     * Controller for all user login-> admin, trainer, student
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        System.out.println("Login");
        customUserDetailsService.setUserType(loginDto.getUsertype());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication, loginDto.getUsertype().toString());
        System.out.println("TOKEN "+token);
        return new ResponseEntity<>(new JwtResponse(token,loginDto.getEmail()), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        System.out.println("Registering User");
     ResponseEntity<?> response = registerService.register(registerDto);
     if(response.getStatusCode() == HttpStatus.BAD_REQUEST){
         return new ResponseEntity<>("Email is already registered !!", HttpStatus.BAD_REQUEST);
     }
       return new ResponseEntity<>("Registration Successfully Done", HttpStatus.OK);

    }

    @GetMapping("/currentUser")
    public User getCurrentUer(Principal principal){
        System.out.println("Getting current User");
        return (User)(this.customUserDetailsService.loadUserByUsername(principal.getName()));
    }

}
