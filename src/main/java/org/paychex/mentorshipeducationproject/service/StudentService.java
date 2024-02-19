package org.paychex.mentorshipeducationproject.service;


import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.Dto.MentorshipDto;
import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.exceptions.NoRecordFoundException;
import org.paychex.mentorshipeducationproject.mapper.CourseMapper;
import org.paychex.mentorshipeducationproject.mapper.MentorshipMapper;
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
        Student student = studentRepository.findStudentByStudentId(studentId);
        if(student == null){
            throw new NoRecordFoundException("Student Not Found");
        }
        List<CourseDto> courses= new ArrayList<>();
        for(Course c : student.getCourses()){
            courses.add(CourseMapper.mapToCourseDto(c));
        }
        return courses;
    }

    public List<MentorshipDto> getAllEnrolledMentorship(Long studentId){
        Student student = studentRepository.findStudentByStudentId(studentId);
        if(student == null){
            throw new NoRecordFoundException("Student Not Found");
        }
        List<MentorshipDto> mentorship = new ArrayList<>();
        for(Mentorship m : student.getMentorshipList()){
            mentorship.add(MentorshipMapper.mapToMentorshipDto(m));
        }
        return mentorship;
    }
}
