package com.byAJ.persistence.repositories;

import com.byAJ.persistence.models.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
    
}
