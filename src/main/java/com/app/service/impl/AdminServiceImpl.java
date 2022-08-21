package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.repo.AdminRepo;
import com.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin findByAdminId(String adminIdData) {
		return this.adminRepo.findByAdminId(adminIdData);
	}

}
