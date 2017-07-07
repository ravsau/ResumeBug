package com.byAJ.persistence.services;

import com.byAJ.persistence.models.User;
import com.byAJ.persistence.repositories.RoleRepository;
import com.byAJ.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("SEEKER")));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void saveRecruiter(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("RECRUITER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
