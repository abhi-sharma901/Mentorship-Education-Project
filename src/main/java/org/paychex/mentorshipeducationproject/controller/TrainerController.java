package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.service.CourseService;
import org.paychex.mentorshipeducationproject.service.MentorshipService;
import org.paychex.mentorshipeducationproject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onlineMentorship/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MentorshipService mentorshipService;

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer){
        return trainerService.createTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> showTrainers(){
        return trainerService.listAllTrainers();
    }

    @GetMapping("/showTrainer/{email}")
    public Trainer getTrainerByEmail(@PathVariable String email){
        return trainerService.findTrainerByEmail(email);
    }

    @GetMapping("/Login/{email}/{password}")
    public Trainer getTrainerByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        Trainer trainer = trainerService.findTrainerByEmailAndPassword(email,password);
        if(trainer == null)
            throw new RuntimeException("No user found");
        return trainer;
    }

    @PutMapping("/updateTrainer")
    public ResponseEntity<Integer> updateUserProfile(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainerDetails(trainer));
    }

    @PutMapping("/updateTrainerPassword")
    public ResponseEntity<Integer> updateUserPassword(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainerPassword(trainer.getEmail(),trainer.getPassword()));

    }

    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @PostMapping("/createMentorship")
    public Mentorship createMentorship(@RequestBody Mentorship mentorship){
        return mentorshipService.createMentorship(mentorship);
    }

    @PostMapping("/assignCourse/{tid}/{cid}")
    public Trainer assignCourseToTrainer(@PathVariable Long tid, @PathVariable Long cid){
        return trainerService.assignCourseToTrainer(tid,cid);
    }

    @PostMapping("/assignMentorship/{tid}/{mid}")
    public Trainer assignMentorshipToTrainer(@PathVariable Long tid, @PathVariable Long mid){
        return trainerService.assignMentorshipToTrainer(tid,mid);
    }

}
