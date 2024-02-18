package org.paychex.mentorshipeducationproject.service;

import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.mapper.StudentMapper;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.paychex.mentorshipeducationproject.repository.PaymentRepository;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course findCourseByCourseId(Long courseId) {
        return courseRepository.findCourseByCourseId(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<StudentDto> getEnrolledStudents(Long courseId){
        List<Long> sids = new ArrayList<>(paymentRepository.getEnrolledStudents(courseId));
        List<StudentDto> students = new ArrayList<>();
        for(Long sid : sids){
            students.add(StudentMapper.mapToStudentDto(studentRepository.findStudentByStudentId(sid)));
        }
        return students;

    }

}
