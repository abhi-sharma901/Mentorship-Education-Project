package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.Dto.TrainerDto;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.mapper.StudentMapper;
import org.paychex.mentorshipeducationproject.service.PaymentService;
import org.paychex.mentorshipeducationproject.service.StudentService;
import org.paychex.mentorshipeducationproject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/onlineMentorship/admin")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TrainerService trainerService;



//    view all courses/mentorships
//    assign mentorship/course to a trainer
    @GetMapping("/viewAllStudents")
    public List<StudentDto> viewAllStudents() {
        return studentService.listAllStudents();
    }

    @GetMapping("/viewAllTrainers")
    public List<TrainerDto> viewAllTrainers(){
        return trainerService.viewAllTrainers();
    }

    @PostMapping("/assignCourse/{tid}/{cid}")
    public Trainer assignCourseToTrainer(@PathVariable Long tid, @PathVariable Long cid){
        return trainerService.assignCourseToTrainer(tid,cid);
    }

    @PostMapping("/assignMentorship/{tid}/{mid}")
    public Trainer assignMentorshipToTrainer(@PathVariable Long tid, @PathVariable Long mid){
        return trainerService.assignMentorshipToTrainer(tid,mid);
    }

//    public List<CourseDto> viewAllCourses
}
