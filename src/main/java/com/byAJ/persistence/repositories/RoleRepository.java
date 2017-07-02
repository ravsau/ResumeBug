package com.byAJ.persistence.repositories;

import com.byAJ.persistence.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRole(String role);
}
