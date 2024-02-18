package org.paychex.mentorshipeducationproject.mapper;

import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setStatus(student.getStatus());
        return studentDto;
    }
}
