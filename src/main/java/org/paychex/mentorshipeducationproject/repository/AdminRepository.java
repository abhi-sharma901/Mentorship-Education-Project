package org.paychex.mentorshipeducationproject.repository;

import org.paychex.mentorshipeducationproject.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findAdminByEmail(String email);

    public Boolean existsAdminByEmail(String email);


}
