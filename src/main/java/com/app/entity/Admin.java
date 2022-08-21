package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin {
	
	@Id
	private String adminId;
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
