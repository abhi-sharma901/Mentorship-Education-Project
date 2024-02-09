package org.paychex.mentorshipeducationproject.controller;

import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onlineMentorship/trainer")
public class TrainerController {

    @Autowired
    private TrainerService TrainerService;

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer){
        return TrainerService.createTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> showTrainers(){
        return TrainerService.listAllTrainers();
    }

    @GetMapping("/showTrainer/{email}")
    public Trainer getTrainerByEmail(@PathVariable String email){
        return TrainerService.findTrainerByEmail(email);
    }

    @GetMapping("/Login/{email}/{password}")
    public Trainer getTrainerByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        Trainer trainer = TrainerService.findTrainerByEmailAndPassword(email,password);
        if(trainer == null)
            throw new RuntimeException("No user found");
        return trainer;
    }

    @PutMapping("/updateTrainer")
    public ResponseEntity<Integer> updateUserProfile(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(TrainerService.updateTrainerDetails(trainer));
    }

    @PutMapping("/updateTrainerPassword")
    public ResponseEntity<Integer> updateUserPassword(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(TrainerService.updateTrainerPassword(trainer.getEmail(),trainer.getPassword()));

    }
}
