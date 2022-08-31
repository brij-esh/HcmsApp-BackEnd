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
@Table(name="pharmacy_table")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {

	@Id
	private String pharmacyId;
	private String pharmacyName;
	private String pharmacyOwner;
	private String pharmacyPassword;
	private String pharmacyPhone;
	private String pharmacyEmail;
	
}
