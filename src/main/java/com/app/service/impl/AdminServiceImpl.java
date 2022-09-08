package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.AdminConverter;
import com.app.dto.AdminDTO;
import com.app.entity.Admin;
import com.app.repo.AdminRepo;
import com.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;


	@Autowired
	private AdminConverter adminConverter;

	@Override
	public AdminDTO findByAdminId(AdminDTO adminDTO) {
		Admin admin = adminConverter.convertDtoToEntity(adminDTO);
		admin = adminRepo.findByAdminId(admin.getAdminId());
		return adminConverter.convertEntityToDto(admin);
	}


}
