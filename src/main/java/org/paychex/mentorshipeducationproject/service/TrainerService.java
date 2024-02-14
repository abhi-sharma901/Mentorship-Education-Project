package org.paychex.mentorshipeducationproject.service;

import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Mentorship;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.repository.CourseRepository;
import org.paychex.mentorshipeducationproject.repository.MentorshipRepository;
import org.paychex.mentorshipeducationproject.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository TrainerRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MentorshipRepository mentorshipRepository;

    public Trainer createTrainer(Trainer t){
        Trainer trainer = TrainerRepository.findTopOneByOrderByTrainerIdDesc();
        long id = 1;
        if(trainer != null){
            id = trainer.getTrainerId() + 1;
        }
        t.setTrainerId(id);
        return TrainerRepository.save(t);
    }

    public List<Trainer> listAllTrainers(){
        return TrainerRepository.findAll();
    }

    public Trainer findTrainerByEmailAndPassword(String email, String password){
        return TrainerRepository.findByEmailAndPassword(email,password);
    }


    @Transactional
    public int updateTrainerPassword(String email, String password){
        return TrainerRepository.updateTrainerPassword(email,password);
    }

    @Transactional
    public int updateTrainerDetails(Trainer trainer){

        return TrainerRepository.updateTrainerDetails(trainer.getEmail(),trainer.getContactNumber(),trainer.getUserName());
    }

    public Trainer findTrainerByEmail(String email){
        return TrainerRepository.findTrainerByEmail(email);
    }

    public Trainer assignCourseToTrainer(Long trainerId, Long courseId){
        Trainer trainer = TrainerRepository.findTrainerByTrainerId(trainerId);
        Course course = courseRepository.findCourseByCourseId(courseId);
        if(!trainer.getIsActive()){
            throw new RuntimeException("Trainer is not active");
        }
        course.setTrainer(trainer);
        trainer.getCourseList().add(course);
        trainer.setIsActive(false);
        return TrainerRepository.save(trainer);
    }

    public Trainer assignMentorshipToTrainer(Long trainerId, Long mentorshipId){
        Trainer trainer = TrainerRepository.findTrainerByTrainerId(trainerId);
        Mentorship mentorship = mentorshipRepository.findMentorshipByMentorshipId(mentorshipId);
        if(!trainer.getIsActive()){
            throw new RuntimeException("Trainer is not active");
        }
        mentorship.setTrainer(trainer);
        trainer.getMentorshipList().add(mentorship);
        trainer.setIsActive(false);
        return TrainerRepository.save(trainer);
    }
}