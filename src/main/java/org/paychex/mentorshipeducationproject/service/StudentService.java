package org.paychex.mentorshipeducationproject.service;


import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.exceptions.NoRecordFoundException;
import org.paychex.mentorshipeducationproject.mapper.CourseMapper;
import org.paychex.mentorshipeducationproject.mapper.StudentMapper;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.paychex.mentorshipeducationproject.repository.PaymentRepository;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public void createStudent(Student s){
        studentRepository.save(s);
    }

    public List<StudentDto> listAllStudents(){
        List<StudentDto> students = new ArrayList<>();
        List<Student> st = studentRepository.findAll();
        for(Student s:st){
            students.add(StudentMapper.mapToStudentDto(s));
        }
        return students;
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
        Student student = studentRepository.findStudentByEmail(email);
        if(student == null){
            throw new NoRecordFoundException();
        }
        return student;
    }

    public List<CourseDto> getAllEnrolledCourses(Long studentId){
        List<Long> cids = new ArrayList<>(paymentRepository.getEnrolledCourse(studentId));
        List<CourseDto> courses= new ArrayList<>();
        for(Long cid : cids){
            courses.add(CourseMapper.mapToCourseDto(courseRepository.findCourseByCourseId(cid)));
            System.out.println();
        }
        for(CourseDto c : courses){
            System.out.println(c);
        }
        return courses;
    }

//    @ExceptionHandler(StudentDoesNotExistsException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> handleStudentDoesNotExistsException(
//            StudentDoesNotExistsException exception
//    ){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(exception.getMessage());
//    }

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
