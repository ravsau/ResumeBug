package com.byAJ.persistence.repositories;


import com.byAJ.persistence.models.Skills;

import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skills, Long>{
    
}
