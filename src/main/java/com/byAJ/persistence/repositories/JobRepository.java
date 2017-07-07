package com.byAJ.persistence.repositories;
import org.springframework.data.repository.CrudRepository;

import com.byAJ.persistence.models.Job;

public interface JobRepository extends CrudRepository<Job, Integer>{

}
