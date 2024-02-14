package org.paychex.mentorshipeducationproject.service;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course findCourseByCourseId(Long courseId) {
        return courseRepository.findCourseByCourseId(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


}
