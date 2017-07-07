package com.byAJ.persistence.repositories;

import com.byAJ.persistence.models.Education;
import com.byAJ.persistence.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education, Integer>{
    
}
