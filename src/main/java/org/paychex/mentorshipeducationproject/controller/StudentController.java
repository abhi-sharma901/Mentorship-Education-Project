package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.Dto.MentorshipDto;
import org.paychex.mentorshipeducationproject.Dto.PaymentDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Payment;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.service.CourseService;
import org.paychex.mentorshipeducationproject.service.PaymentService;
import org.paychex.mentorshipeducationproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/onlineMentorship/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/showStudent/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email){
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Integer> updateUserProfile(@RequestBody Student student)
    {
        return ResponseEntity.ok(studentService.updateStudentDetails(student));
    }

    @PutMapping("/updateStudentPassword")
    public ResponseEntity<Integer> updateUserPassword(@RequestBody Student student)
    {
        return ResponseEntity.ok(studentService.updateStudentPassword(student.getEmail(),student.getPassword()));

    }
    @PostMapping("/course/{sid}/{cid}/payment")
    public Payment makePaymentForCourse(@RequestBody Payment p, @PathVariable Long sid,@PathVariable Long cid){
        return paymentService.makePaymentForCourse(p,sid,cid);
    }

    @PostMapping("/mentorship/{sid}/{mid}/payment")
    public Payment makePaymentForMentorship(@RequestBody Payment p, @PathVariable Long sid,@PathVariable Long mid){
        return paymentService.makePaymentForMentorship(p,sid,mid);
    }

    @GetMapping("/courses/{cid}")
    public Course viewCourse(Long cid){
        return courseService.findCourseByCourseId(cid);
    }
    @GetMapping("/{sid}/myCourses")
    public List<CourseDto> getEnrolledCourses(@PathVariable Long sid){
        return studentService.getAllEnrolledCourses(sid);
    }

    @GetMapping("/{sid}/myMentorships")
    public List<MentorshipDto> getMentorships(@PathVariable Long sid){
        return studentService.getAllEnrolledMentorship(sid);
    }

    @GetMapping("/{sid}/myPayments")
    public List<PaymentDto> getPayments(@PathVariable Long sid){
        return paymentService.getPaymentsByStudent(sid);
    }

}
