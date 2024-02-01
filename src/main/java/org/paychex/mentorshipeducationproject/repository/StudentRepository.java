package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findStudentByStudentId(long studentId);

    public Student findTopOneByOrderByStudentIdDesc();

    public Student findStudentByUserName(String userName);
    public Student findStudentByEmail(String email);

    public Student findByEmailAndPassword(String email, String password);

    @Modifying
    @Query(value= "update Student s set s.pass_word =:password where s.email=:email", nativeQuery = true)
    public int updateStudentPassword(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query(value= "update Student s set s.contact_number = :contactNumber, s.username= :userName where s.email=:email", nativeQuery = true)
    public int updateStudentDetails(@Param("email") String email,@Param("contactNumber") String contactNumber, @Param("userName") String userName);


}
