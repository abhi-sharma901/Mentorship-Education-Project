package org.paychex.mentorshipeducationproject.service;

import jakarta.transaction.Transactional;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer t){
        return trainerRepository.save(t);
    }

    public List<Trainer> listAllTrainers(){
        return trainerRepository.findAll();
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

        return trainerRepository.updateTrainerDetails(trainer.getEmail(),trainer.getContactNumber(),trainer.getUserName());
    }

    public Trainer findTrainerByEmail(String email){
        return trainerRepository.findTrainerByEmail(email);

    }
}