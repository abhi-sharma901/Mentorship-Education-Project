package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorshipRepository extends JpaRepository<Mentorship,Long> {
    public Mentorship findMentorshipByMentorshipId(Long id);
}
