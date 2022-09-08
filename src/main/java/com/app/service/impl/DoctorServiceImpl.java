package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.DoctorConverter;
import com.app.dto.DoctorDTO;
import com.app.entity.Doctor;
import com.app.exception.DoctorNotFoundException;
import com.app.repo.DoctorRepo;
import com.app.service.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private DoctorConverter doctorConverter;

	@Override
	public DoctorDTO createDoctor(DoctorDTO doctorDTO) throws DoctorNotFoundException {

		Doctor doctor = this.doctorRepo.findByDoctorId(this.doctorConverter.convertDtoToEntity(doctorDTO).getDoctorId());
		String generatedDoctorId = "";
		if(doctor!=null){
			generatedDoctorId += doctorDTO.getDoctorName().substring(0,3).concat(doctorDTO.getDoctorPhone().substring(1,3));
		}else{
			generatedDoctorId += doctorDTO.getDoctorName().substring(0,3).concat(doctorDTO.getDoctorPhone().substring(0,3));
		}
		doctorDTO.setDoctorId(generatedDoctorId);
		doctor = this.doctorConverter.convertDtoToEntity(doctorDTO);
		this.doctorRepo.save(doctor);
		return doctorDTO;
	}

	@Override
	public Doctor findByDoctorId(String doctorIdData) {
		return this.doctorRepo.findByDoctorId(doctorIdData);
	}

	@Override
	public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = this.doctorRepo.findByDoctorId(doctorDTO.getDoctorId());
		doctor.setDoctorEmail(doctorDTO.getDoctorEmail());
		doctor.setDoctorName(doctorDTO.getDoctorName());
		doctor.setDoctorPassword(doctorDTO.getDoctorPassword());
		doctor.setDoctorPhone(doctorDTO.getDoctorPhone());
		doctor.setSpecialization(doctorDTO.getSpecialization());
		doctor.setDoctorImageUrl(doctorDTO.getDoctorImageUrl());
		this.doctorRepo.save(doctor);
		return this.doctorConverter.convertEntityToDto(doctor);
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
