package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pharmacy_table")
public class Pharmacy {

	@Id
	private String pharmacyId;
	private String pharmacyName;
	private String pharmacyOwner;
	private String pharmacyPassword;
	private String pharmacyPhone;
	private String pharmacyEmail;
	
	public Pharmacy(String pharmacyId, String pharmacyName, String pharmacyOwner, String pharmacyPassword,
			String pharmacyPhone, String pharmacyEmail) {
		super();
		this.pharmacyId = pharmacyId;
		this.pharmacyName = pharmacyName;
		this.pharmacyOwner = pharmacyOwner;
		this.pharmacyPassword = pharmacyPassword;
		this.pharmacyPhone = pharmacyPhone;
		this.pharmacyEmail = pharmacyEmail;
	}

	public Pharmacy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getPharmacyOwner() {
		return pharmacyOwner;
	}

	public void setPharmacyOwner(String pharmacyOwner) {
		this.pharmacyOwner = pharmacyOwner;
	}

	public String getPharmacyPassword() {
		return pharmacyPassword;
	}

	public void setPharmacyPassword(String pharmacyPassword) {
		this.pharmacyPassword = pharmacyPassword;
	}

	public String getPharmacyPhone() {
		return pharmacyPhone;
	}

	public void setPharmacyPhone(String pharmacyPhone) {
		this.pharmacyPhone = pharmacyPhone;
	}

	public String getPharmacyEmail() {
		return pharmacyEmail;
	}

	public void setPharmacyEmail(String pharmacyEmail) {
		this.pharmacyEmail = pharmacyEmail;
	}
	
}
