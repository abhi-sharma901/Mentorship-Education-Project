package org.paychex.mentorshipeducationproject.service;

import org.paychex.mentorshipeducationproject.Dto.RegisterDto;
import org.paychex.mentorshipeducationproject.entity.*;
import org.paychex.mentorshipeducationproject.utils.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterDto registerDto){
        if(registerDto.getUsertype() == UserType.STUDENT){
            if(studentService.checkStudentExists(registerDto.getEmail())) {
                return new ResponseEntity<>("Email is already registered !!", HttpStatus.BAD_REQUEST);
            }
            Student student = new Student(registerDto.getFirstName(),registerDto.getLastName(),registerDto.getContactNumber(), registerDto.getPassword(),registerDto.getEmail());
            student.setPassword(passwordEncoder.encode(student.getPassword()));
            studentService.createStudent(student);
        }
        else
            if(registerDto.getUsertype() == UserType.TRAINER){
            if(trainerService.checkTrainerExistsByEmail(registerDto.getEmail())) {
                return new ResponseEntity<>("Email is already registered !!", HttpStatus.BAD_REQUEST);
            }
            Trainer trainer = new Trainer(registerDto.getFirstName(),registerDto.getLastName(),registerDto.getContactNumber(), registerDto.getPassword(),registerDto.getEmail());
            trainer.setPassword(passwordEncoder.encode(trainer.getPassword()));
            trainerService.createTrainer(trainer);
        }

        System.out.println("Profile Created Successfully !!");
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
