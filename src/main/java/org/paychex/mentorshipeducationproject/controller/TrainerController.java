package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.Dto.MentorshipDto;
import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.service.CourseService;
import org.paychex.mentorshipeducationproject.service.MentorshipService;
import org.paychex.mentorshipeducationproject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/onlineMentorship/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MentorshipService mentorshipService;

    @GetMapping("/showTrainer/{email}")
    public Trainer getTrainerByEmail(@PathVariable String email){
        return trainerService.findTrainerByEmail(email);
    }

    @PutMapping("/updateTrainer")
    public ResponseEntity<Integer> updateUserProfile(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainerDetails(trainer));
    }

    @PutMapping("/updateTrainerPassword")
    public ResponseEntity<Integer> updateUserPassword(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainerPassword(trainer.getEmail(),trainer.getPassword()));

    }

    @GetMapping("/{courseId}/students")
    public List<StudentDto> getEnrolledStudentsInCourse(@PathVariable Long courseId){
        return courseService.getEnrolledStudents(courseId);
    }

    @GetMapping("/{mentorshipId}/student")
    public StudentDto getEnrolledStudentInMentorship(@PathVariable Long mentorshipId){
        return mentorshipService.getEnrolledStudent(mentorshipId);
    }
    @GetMapping("/{trainerId}/assignedCourses")
    public List<CourseDto> getAssignedCourses(@PathVariable Long trainerId){
        return trainerService.viewAssignedCourses(trainerId);
    }

    @GetMapping("/{trainerId}/assignedMentorships")
    public List<MentorshipDto> getAssignedMentorship(@PathVariable Long trainerId){
        return trainerService.viewAssignedMentorship(trainerId);
    }
    @PutMapping("/{TrainerId}/{CourseId}/cancelAssignedCourse")
    public ResponseEntity<?> cancelAssignedCourse(@PathVariable Long TrainerId, @PathVariable Long CourseId){
        return ResponseEntity.ok(trainerService.cancelAssignedCourses(TrainerId,CourseId));
    }

}
