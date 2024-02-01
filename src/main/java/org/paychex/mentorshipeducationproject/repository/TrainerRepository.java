package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    public Trainer findTrainerByTrainerId(long trainerId);

    public Trainer findTopOneByOrderByTrainerIdDesc();

    public Trainer findTrainerByUserName(String userName);

    public Trainer findTrainerByEmail(String email);

    public Trainer findByEmailAndPassword(String email, String password);

    @Modifying
    @Query(value = "update Trainer s set s.pass_word =:password where s.email=:email", nativeQuery = true)
    public int updateTrainerPassword(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query(value = "update Trainer s set s.contact_number = :contactNumber, s.username= :userName where s.email=:email", nativeQuery = true)
    public int updateTrainerDetails(@Param("email") String email, @Param("contactNumber") String contactNumber, @Param("userName") String userName);

}
