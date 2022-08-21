package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String>{

	Admin findByAdminId(String adminIdData);
	
}
