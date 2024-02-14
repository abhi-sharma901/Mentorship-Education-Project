package org.paychex.mentorshipeducationproject.service;


import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public void addCourse(Course course) {
//        this.course.add(course);
//        course.getStudents().add(this);
//    }
}
