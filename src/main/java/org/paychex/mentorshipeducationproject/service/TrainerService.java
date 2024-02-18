package org.paychex.mentorshipeducationproject.service;

import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.Dto.TrainerDto;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.exceptions.NoRecordFoundException;
import org.paychex.mentorshipeducationproject.exceptions.TrainerNotAvailableException;
import org.paychex.mentorshipeducationproject.mapper.TrainerMapper;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.paychex.mentorshipeducationproject.repository.MentorshipRepository;
import org.paychex.mentorshipeducationproject.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MentorshipRepository mentorshipRepository;

    public Trainer createTrainer(Trainer t){
        return trainerRepository.save(t);
    }

    public List<TrainerDto> viewAllTrainers(){
        List<TrainerDto> trainers = new ArrayList<>();
        List<Trainer> trainerList = trainerRepository.findAll();

        for(Trainer t : trainerList){
            trainers.add(TrainerMapper.mapToTrainerDto(t));
        }
        return trainers;
    }

    public Boolean checkTrainerExistsByEmail(String email){
        return trainerRepository.existsTrainersByEmail(email);
    }


    @Transactional
    public int updateTrainerPassword(String email, String password){
        return trainerRepository.updateTrainerPassword(email,password);
    }

    @Transactional
    public int updateTrainerDetails(Trainer trainer){

        return trainerRepository.updateTrainerDetails(trainer.getEmail(),trainer.getContactNumber());
    }

    public Trainer findTrainerByEmail(String email){
        Trainer trainer = trainerRepository.findTrainerByEmail(email);
        if(trainer == null){
            throw new NoRecordFoundException();
        }
        return trainer;
    }

    public Trainer assignCourseToTrainer(Long trainerId, Long courseId){
        Trainer trainer = trainerRepository.findTrainerByTrainerId(trainerId);
        Course course = courseRepository.findCourseByCourseId(courseId);

        if(trainer == null || course == null){
            throw new NoRecordFoundException();
        }
        if(!trainer.getIsActive()){
            throw new TrainerNotAvailableException();
        }

        course.setTrainer(trainer);
        trainer.setAvailableFrom(course.getEndDate());
        trainer.getCourseList().add(course);
        trainer.setIsActive(false);
        return trainerRepository.save(trainer);
    }

    public Trainer assignMentorshipToTrainer(Long trainerId, Long mentorshipId){
        Trainer trainer = trainerRepository.findTrainerByTrainerId(trainerId);
        Mentorship mentorship = mentorshipRepository.findMentorshipByMentorshipId(mentorshipId);

        if(trainer == null || mentorship == null){
            throw new NoRecordFoundException();
        }
        if(!trainer.getIsActive()){
            throw new TrainerNotAvailableException();
        }

        mentorship.setTrainer(trainer);
        trainer.setAvailableFrom(mentorship.getEndDate());
        trainer.getMentorshipList().add(mentorship);
        trainer.setIsActive(false);
        return trainerRepository.save(trainer);
    }
}