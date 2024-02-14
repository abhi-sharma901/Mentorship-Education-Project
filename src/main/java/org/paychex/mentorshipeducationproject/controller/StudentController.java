package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Payment;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.paychex.mentorshipeducationproject.service.CourseService;
import org.paychex.mentorshipeducationproject.service.PaymentService;
import org.paychex.mentorshipeducationproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onlineMentorship/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> showStudents(){
        return studentService.listAllStudents();
    }

    @GetMapping("/showStudent/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        return studentService.findStudentByEmail(email);
    }

    @GetMapping("/Login/{email}/{password}")
    public Student getStudentByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        Student student = studentService.findStudentByEmailAndPassword(email,password);
        if(student == null)
             throw new RuntimeException("No user found");
        return student;
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

    //mentorship

//    public ResponseEntity<String> enrollNewCourse(Long sid,Long cid){
//        return ResponseEntity.ok(courseService.enrollNewCourse(sid,cid));
//    }
}
