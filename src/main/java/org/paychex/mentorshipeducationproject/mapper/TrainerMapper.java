package org.paychex.mentorshipeducationproject.mapper;

import org.paychex.mentorshipeducationproject.Dto.TrainerDto;
import org.paychex.mentorshipeducationproject.entity.Trainer;

public class TrainerMapper {
    public static TrainerDto mapToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setTrainerId(trainer.getTrainerId());
        trainerDto.setFirstName(trainer.getFirstName());
        trainerDto.setLastName(trainer.getLastName());
        trainerDto.setEmail(trainer.getEmail());
        trainerDto.setAvailableFrom(trainer.getAvailableFrom());
        trainerDto.setCancellationCount(trainer.getCancellationCount());
        trainerDto.setPenalty(trainer.getPenalty());
        trainerDto.setIsActive(trainer.getIsActive());
        return trainerDto;
    }
}
