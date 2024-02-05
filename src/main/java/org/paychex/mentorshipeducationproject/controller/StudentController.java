package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.entity.Payment;
import org.paychex.mentorshipeducationproject.entity.Student;
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
    @PostMapping("/{id}/payment")
    public Payment makePayment(@RequestBody Payment p, @PathVariable Long id){
        return paymentService.makePayment(p,id);
    }


//    @GetMapping("/showPreviousCourses/{email}")
//    public String getStudentPreviousCourses(@PathVariable String email){
//        Student student = studentService.findStudentByEmail(email);
//        return student.getPreviousCourses();
//    }
//


}
