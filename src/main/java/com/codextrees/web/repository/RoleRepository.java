package com.codextrees.web.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codextrees.web.models.Role;
import com.codextrees.web.models.RoleType;

public interface RoleRepository extends CrudRepository<Role, Long>{
 
	
	@Query("SELECT r FROM Role r WHERE r.name = :name")
	   public Role findByName(@Param("name") RoleType name);

}
