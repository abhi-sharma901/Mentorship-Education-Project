package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Course;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findStudentByStudentId(long studentId);

    public Student findTopOneByOrderByStudentIdDesc();

    public Boolean existsStudentByEmail(String email);

    public Student findStudentByEmail(String email);

    public Student findByEmailAndPassword(String email, String password);

    @Modifying
    @Query(value= "update Student s set s.password =:password where s.email=:email", nativeQuery = true)
    public int updateStudentPassword(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query(value= "update Student s set s.contact_number = :contactNumber where s.email=:email", nativeQuery = true)
    public int updateStudentDetails(@Param("email") String email,@Param("contactNumber") String contactNumber);


}
