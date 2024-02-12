package org.paychex.mentorshipeducationproject.service;

import jakarta.transaction.Transactional;
import org.apache.el.parser.BooleanNode;
import org.paychex.mentorshipeducationproject.entity.Admin;
import org.paychex.mentorshipeducationproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin findAdminByEmail(String email){
        return adminRepository.findAdminByEmail(email);
    }

    public Boolean checkAdminExistsByEmail(String email){
        return adminRepository.existsAdminByEmail(email);
    }

    @Transactional
    public Admin createAdmin(Admin admin){
       return adminRepository.save(admin);
    }



}
