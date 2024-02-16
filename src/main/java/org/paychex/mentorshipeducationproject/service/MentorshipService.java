package org.paychex.mentorshipeducationproject.service;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.repository.MentorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
