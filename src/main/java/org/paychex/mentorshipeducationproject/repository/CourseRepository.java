package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findCourseByCourseId(Long courseId);
     public List<Course> findCourseByTrainer(Trainer trainer);

}
