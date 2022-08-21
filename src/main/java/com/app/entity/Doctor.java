package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="doctor_table")
public class Doctor {
	
	@Id
	private String doctorId;
	private String doctorName;
	private String specialization;
	private String doctorPassword;
	private String doctorPhone;
	private String doctorEmail;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorId, String doctorName, String specialization, String doctorPassword, String doctorPhone,
			String doctorEmail) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.doctorPassword = doctorPassword;
		this.doctorPhone = doctorPhone;
		this.doctorEmail = doctorEmail;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	public String getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	
	

}
