package org.paychex.mentorshipeducationproject.service;


import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student s){
        return studentRepository.save(s);
    }

    public List<Student> listAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentByEmailAndPassword(String email, String password){
        return studentRepository.findByEmailAndPassword(email,password);
    }


    @Transactional
    public int updateStudentPassword(String email, String password){
       return studentRepository.updateStudentPassword(email,password);
    }

    @Transactional
    public int updateStudentDetails(Student student){

       return studentRepository.updateStudentDetails(student.getEmail(),student.getContactNumber(),student.getUserName());
    }

    public Student findStudentByEmail(String email){
        return studentRepository.findStudentByEmail(email);

    }
}
