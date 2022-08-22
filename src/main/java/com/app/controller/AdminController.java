package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Admin;
import com.app.service.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin adminData){
		
		Admin admin = this.adminService.findByAdminId(adminData.getAdminId());
		
		if(admin.getPassword().equals(adminData.getPassword())) {
			return ResponseEntity.ok(admin);
		}
		return (ResponseEntity<Admin>) ResponseEntity.internalServerError();
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		return "redirect:/login";
	}

}
