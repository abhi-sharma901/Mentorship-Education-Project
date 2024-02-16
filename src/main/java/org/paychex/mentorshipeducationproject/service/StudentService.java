package org.paychex.mentorshipeducationproject.service;


import jakarta.transaction.Transactional;
import org.apache.el.util.ExceptionUtils;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.exceptions.ErrorResponse;
import org.paychex.mentorshipeducationproject.exceptions.StudentDoesNotExistsException;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student createStudent(Student s){
        return studentRepository.save(s);
    }

    public List<Student> listAllStudents(){
        return studentRepository.findAll();
    }

    public Boolean checkStudentExists(String email){
        return studentRepository.existsStudentByEmail(email);
    }

    @Transactional
    public int updateStudentPassword(String email, String password){
        password = passwordEncoder.encode(password);
       return studentRepository.updateStudentPassword(email,password);
    }

    @Transactional
    public int updateStudentDetails(Student student){

       return studentRepository.updateStudentDetails(student.getEmail(),student.getContactNumber());
    }

    public Student findStudentByEmail(String email){
        return studentRepository.findStudentByEmail(email);
    }
    public Student addCourse(Student student, Course course){
        student.getCourse().add(course);
        course.getStudents().add(student);
        return student;
    }

    public Set<Course> getAllEnrolledCourses(Long studentId){
        if(!studentRepository.existsById(studentId)){
            throw new RuntimeException("Student not found");
        }
        Student student = studentRepository.findStudentByStudentId(studentId);
        return student.getCourse();
    }

    @ExceptionHandler(StudentDoesNotExistsException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleStudentDoesNotExistsException(
            StudentDoesNotExistsException exception
    ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

//    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
//        MethodArgumentNotValidException ex,
//        WebRequest request
//    ){
//        log.error("Failed to find the requested element", ex);
//        return buildErrorResponse(ex, HttpStatus.NOT_FOUND,request);
//    }
//
//
//    private ResponseEntity<ErrorResponse> buildErrorResponse(
//        Exception ex,
//        HttpStatus status,
//        WebRequest request
//    ){
//        return buildErrorResponse(
//                ex,
//                ex.getMessage(),
//                status,
//                request);
//    }
//
//    private ResponseEntity<ErrorResponse> buildErrorResponse(
//        Exception ex,
//        String message,
//        HttpStatus status,
//        WebRequest request
//    ){
//        ErrorResponse errorResponse = new ErrorResponse(
//                status.value(),
//                message
//        );
//        if(printStackTrace && isTraceOn(request)){
//            errorResponse.setStackTrace(ExceptionUtils.getStackTrace(ex));
//        }
//        return ResponseEntity.status(status).body(errorResponse);
//    }
//
//    private boolean isTraceOn(WebRequest request) {
//        String [] value = request.getParameterValues(TRACE);
//        return Objects.nonNull(value)
//                && value.length > 0
//                && value[0].contentEquals("true");
//    }
}
