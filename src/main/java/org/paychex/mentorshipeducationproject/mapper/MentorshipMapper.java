package org.paychex.mentorshipeducationproject.mapper;

import org.paychex.mentorshipeducationproject.Dto.MentorshipDto;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
/**
 * Course Mentorship to map course to mentorship DTO
 */
public class MentorshipMapper {
    public static MentorshipDto mapToMentorshipDto(Mentorship mentorship) {
        MentorshipDto mentorshipDto= new MentorshipDto();
        mentorshipDto.setMentorshipId(mentorship.getMentorshipId());
        mentorshipDto.setMentorshipName(mentorship.getMentorshipName());
        mentorshipDto.setMentorshipDescription(mentorship.getMentorshipDescription());
        mentorshipDto.setStartDate(mentorship.getStartDate());
        mentorshipDto.setEndDate(mentorship.getEndDate());
        mentorshipDto.setMentorshipCost(mentorship.getMentorshipCost());
        mentorshipDto.setImageUrl(mentorship.getImageUrl());
        mentorshipDto.setStatus(mentorship.getStatus());

        return mentorshipDto;
    }
}
