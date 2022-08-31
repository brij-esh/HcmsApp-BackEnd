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
	public Doctor createDoctor(Doctor doctorData) throws Exception {
		Doctor doctor = this.doctorRepo.findByDoctorId(doctorData.getDoctorId());
		String generatedDoctorId = "";
		if(doctor!=null){
			generatedDoctorId += doctorData.getDoctorName().substring(0,3).concat(doctorData.getDoctorPhone().substring(1,3));
		}else{
			generatedDoctorId += doctorData.getDoctorName().substring(0,3).concat(doctorData.getDoctorPhone().substring(0,3));
		}
		try {
			doctorData.setDoctorId(generatedDoctorId);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return this.doctorRepo.save(doctorData);
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
		doctor.setDoctorImageUrl(doctorData.getDoctorImageUrl());
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
