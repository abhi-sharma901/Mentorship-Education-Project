package org.paychex.mentorshipeducationproject.mapper;

import org.paychex.mentorshipeducationproject.Dto.CourseDto;
import org.paychex.mentorshipeducationproject.entity.Course;

/**
 * Course mapper to map course to course DTO
 */
public class CourseMapper {
    public static CourseDto mapToCourseDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseDescription(course.getCourseDescription());
        courseDto.setStartDate(course.getStartDate());
        courseDto.setEndDate(course.getEndDate());
        courseDto.setCourseCost(course.getCourseCost());
        courseDto.setStatus(course.getStatus());
        courseDto.setImageUrl(course.getImageUrl());
        return courseDto;
    }

}
