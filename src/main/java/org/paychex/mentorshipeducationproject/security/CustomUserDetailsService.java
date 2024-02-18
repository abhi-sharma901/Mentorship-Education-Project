package org.paychex.mentorshipeducationproject.security;


import org.paychex.mentorshipeducationproject.entity.Admin;
import org.paychex.mentorshipeducationproject.entity.Student;
import org.paychex.mentorshipeducationproject.entity.Trainer;
import org.paychex.mentorshipeducationproject.entity.UserType;
import org.paychex.mentorshipeducationproject.repository.AdminRepository;
import org.paychex.mentorshipeducationproject.repository.StudentRepository;
import org.paychex.mentorshipeducationproject.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private StudentRepository studentRepository;

    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(userType);

        if(userType==UserType.ADMIN) {
            Admin admin = adminRepository.findAdminByEmail(username);
            if(admin.equals(null))
            {
                throw( new UsernameNotFoundException("Admin Email "+ username+ "not found"));
            }
            SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.ADMIN.toString());
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(adminAuthority);
            return new User(admin.getEmail(), admin.getPassword(), authorities);
        }
        else if(userType == UserType.TRAINER) {

            Trainer trainer= trainerRepository.findTrainerByEmail(username);
            if(trainer.equals(null)){
                throw( new UsernameNotFoundException("Trainer Email "+ username+ "not found"));
            }
            SimpleGrantedAuthority trainerAuthority = new SimpleGrantedAuthority(UserType.TRAINER.toString());
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(trainerAuthority);
            return new User(trainer.getEmail()
                    , trainer.getPassword(),
                    authorities);
        }
        else if(userType == UserType.STUDENT) {
            Student student = studentRepository.findStudentByEmail(username);
                    if(student.equals(null)){
                        throw( new UsernameNotFoundException("User Email "+ username+ "not found"));
                    }
            SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.STUDENT.toString());
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(adminAuthority);
            return new User(student.getEmail(), student.getPassword(), authorities);

        }
        return null;
    }
}
