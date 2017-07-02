package com.byAJ.persistence.repositories;


import com.byAJ.persistence.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);
}