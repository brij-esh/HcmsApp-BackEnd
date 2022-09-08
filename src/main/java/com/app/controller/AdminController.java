package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminDTO;
import com.app.service.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/login")
	public ResponseEntity<AdminDTO> loginAdmin(@RequestBody AdminDTO adminDTO){
		
		AdminDTO adminDTO2 = adminService.findByAdminId(adminDTO);

		if(adminDTO2.getPassword().equals(adminDTO.getPassword())){
			return new ResponseEntity<>(adminDTO2, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		return "redirect:/login";
	}

}
