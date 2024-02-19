package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.Dto.TrainerDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.mapper.StudentMapper;
import org.paychex.mentorshipeducationproject.service.*;
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
    @Autowired
    private CourseService courseService;
    @Autowired
    private MentorshipService mentorshipService;

    /**
     * Controller to view all the users registered as students
     * @return List<StudentDto>
     */
    @GetMapping("/viewAllStudents")
    public List<StudentDto> viewAllStudents() {
        return studentService.listAllStudents();
    }

    /**
     * Controller to view all the users registered as trainers
     * @return  List<TrainerDto>
     */
    @GetMapping("/viewAllTrainers")
    public List<TrainerDto> viewAllTrainers(){
        return trainerService.viewAllTrainers();
    }

    /**
     * Controller to create a course
     * @param course
     * @return
     */
    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    /**
     * Controller to create a mentorship
     * @param mentorship
     * @return
     */
    @PostMapping("/createMentorship")
    public Mentorship createMentorship(@RequestBody Mentorship mentorship){
        return mentorshipService.createMentorship(mentorship);
    }

    /**
     * Controller to assign a course to a trainer
     * @param tid
     * @param cid
     * @return
     */
    @PostMapping("/assignCourse/{tid}/{cid}")
    public Trainer assignCourseToTrainer(@PathVariable Long tid, @PathVariable Long cid){
        return trainerService.assignCourseToTrainer(tid,cid);
    }

    /**
     * Controller to assign a mentorship to a trainer
     * @param tid
     * @param mid
     * @return
     */
    @PostMapping("/assignMentorship/{tid}/{mid}")
    public Trainer assignMentorshipToTrainer(@PathVariable Long tid, @PathVariable Long mid){
        return trainerService.assignMentorshipToTrainer(tid,mid);
    }

}
