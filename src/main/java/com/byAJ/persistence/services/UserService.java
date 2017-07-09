package com.byAJ.persistence.services;

import com.byAJ.persistence.models.Education;
import com.byAJ.persistence.models.Job;
import com.byAJ.persistence.models.Person;
import com.byAJ.persistence.models.Skills;
import com.byAJ.persistence.models.User;
import com.byAJ.persistence.repositories.EducationRepository;
import com.byAJ.persistence.repositories.JobRepository;
import com.byAJ.persistence.repositories.PersonRepository;
import com.byAJ.persistence.repositories.RoleRepository;
import com.byAJ.persistence.repositories.SkillRepository;
import com.byAJ.persistence.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired 
    EducationRepository eduRepository;
    @Autowired 
    JobRepository jobRepository;
    @Autowired 
    SkillRepository skillRepository;
    
    @Autowired 
    PersonRepository personRepository;

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

    public  User getUserDetails(){
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	
    	
    	return userRepository.findByUsername(auth.getName());
    }
    public void saveRecruiter(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("RECRUITER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
    
    
    public void saveEducation(Education edu){
    	
    	eduRepository.save(edu);
    }
    
 public void savePerson(Person person){
    	
    	personRepository.save(person);
    }
    
public void saveJob(Job job){
    	
    	jobRepository.save(job);
    }

public void saveSkill(Skills skill){
	
	skillRepository.save(skill);
}

}
