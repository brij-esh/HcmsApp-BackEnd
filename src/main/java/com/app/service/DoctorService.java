package com.app.service;

import java.util.List;

import com.app.dto.DoctorDTO;
import com.app.entity.Doctor;
import com.app.exception.DoctorNotFoundException;

public interface DoctorService {

	public DoctorDTO createDoctor(DoctorDTO doctorDTO) throws DoctorNotFoundException;

	public Doctor findByDoctorId(String doctorIdData);
	
	public DoctorDTO updateDoctor(DoctorDTO doctorDTO);
	
	public List<Doctor> getDoctorList();
	
	public String deleteDoctor(String doctorIdData);
}
