package org.paychex.mentorshipeducationproject.service;

import org.paychex.mentorshipeducationproject.Dto.StudentDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.exceptions.NoRecordFoundException;
import org.paychex.mentorshipeducationproject.mapper.MentorshipMapper;
import org.paychex.mentorshipeducationproject.mapper.StudentMapper;
import org.paychex.mentorshipeducationproject.repository.MentorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorshipService {

    @Autowired
    private MentorshipRepository mentorshipRepository;

    public Mentorship createMentorship(Mentorship mentorship) {
        return mentorshipRepository.save(mentorship);
    }

    public List<Mentorship> getAllMentorships() {
        return mentorshipRepository.findAll();
    }

    public StudentDto getEnrolledStudent(Long mentorshipId) {
        Mentorship mentorship = mentorshipRepository.findMentorshipByMentorshipId(mentorshipId);
        if(mentorship == null){
            throw new NoRecordFoundException("Mentorship not found");
        }
        return StudentMapper.mapToStudentDto(mentorship.getStudent());
    }
}
