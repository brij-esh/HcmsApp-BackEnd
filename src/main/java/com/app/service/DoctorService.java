package com.app.service;

import java.util.List;

import com.app.entity.Doctor;

public interface DoctorService {

	public Doctor createDoctor(Doctor doctor) throws Exception;

	public Doctor findByDoctorId(String doctorIdData);
	
	public Doctor updateDoctor(Doctor doctorData);
	
	public List<Doctor> getDoctorList();
	
	public String deleteDoctor(String doctorIdData);
}
