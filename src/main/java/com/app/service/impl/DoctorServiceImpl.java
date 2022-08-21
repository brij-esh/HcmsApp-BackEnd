package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Doctor;
import com.app.repo.DoctorRepo;
import com.app.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	
	@Autowired
	private DoctorRepo doctorRepo;

	@Override
	public Doctor createDoctor(Doctor doctor) throws Exception {
		
		Doctor doctor2 = this.doctorRepo.findByDoctorId(doctor.getDoctorId());
		if(doctor2!=null) {
			System.out.println("Doctor already present with doctor id: "+doctor.getDoctorId());
			throw new Exception("Doctor already present with doctor id: "+doctor.getDoctorId());
		}else {
			doctor2 = this.doctorRepo.save(doctor);
		}
		return doctor2;
	}

	@Override
	public Doctor findByDoctorId(String doctorIdData) {
		return this.doctorRepo.findByDoctorId(doctorIdData);
	}

	@Override
	public Doctor updateDoctor(Doctor doctorData) {
		Doctor doctor = this.doctorRepo.findByDoctorId(doctorData.getDoctorId());
		doctor.setDoctorEmail(doctorData.getDoctorEmail());
		doctor.setDoctorName(doctorData.getDoctorName());
		doctor.setDoctorPassword(doctorData.getDoctorPassword());
		doctor.setDoctorPhone(doctorData.getDoctorPhone());
		doctor.setSpecialization(doctorData.getSpecialization());
		this.doctorRepo.save(doctor);
		return doctor;
	}

	@Override
	public List<Doctor> getDoctorList() {
		return this.doctorRepo.findAll();
	}

	@Override
	public String deleteDoctor(String doctorIdData) {
		this.doctorRepo.deleteByDoctorId(doctorIdData);
		return doctorIdData+" doctor deleted";
	}

}
