package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admin_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	@Id
	private String adminId;
	private String password;
	

}
