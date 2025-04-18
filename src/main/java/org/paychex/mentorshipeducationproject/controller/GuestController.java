package org.paychex.mentorshipeducationproject.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.service.CourseService;
import org.paychex.mentorshipeducationproject.service.MentorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller For guest users to view courses and mentorship available
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/onlineMentorship/guest")
public class GuestController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private MentorshipService mentorshipService;


    @GetMapping("/viewCourses")
    public ResponseEntity<List<Course> >viewAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/viewMentorships")
    public ResponseEntity<List<Mentorship> >viewAllMentorship(){
        return ResponseEntity.ok(mentorshipService.getAllMentorships());
    }

}
