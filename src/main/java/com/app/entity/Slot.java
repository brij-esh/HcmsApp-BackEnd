package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "slot_table")
public class Slot {

	@Id
	private String slotId;
	private String patientName;
	private int patientAge;
	private LocalDate slotDate;
	private String doctorId;
	private String patientPhone;
	private String symptoms;
	private String prescription;

	public Slot(String slotId, String patientName, int patientAge, LocalDate slotDate, String doctorId, String patientPhone,
			String prescription, String symptoms) {
		super();
		this.slotId = slotId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientPhone = patientPhone;
		this.slotDate = slotDate;
		this.doctorId = doctorId;
		this.prescription = prescription;
		this.symptoms = symptoms;
	}
	public Slot() {
		super();
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public LocalDate getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	
}
