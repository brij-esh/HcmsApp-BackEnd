package com.app.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.converter.DoctorConverter;
import com.app.dto.DoctorDTO;
import com.app.entity.Doctor;
import com.app.exception.DoctorNotFoundException;
import com.app.service.DoctorService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("http://localhost:4200")
@Log4j2
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private DoctorConverter doctorConverter;
	
	@PostMapping("/login")
	public ResponseEntity<DoctorDTO> loginDoctor(@RequestBody DoctorDTO doctorDTO){
		Doctor doctor = this.doctorService.findByDoctorId(this.doctorConverter.convertDtoToEntity(doctorDTO).getDoctorId());
		if(doctor.getDoctorPassword().equals(doctorDTO.getDoctorPassword())) {
			DoctorDTO doctorDTO2 = this.doctorConverter.convertEntityToDto(doctor);
			return new ResponseEntity<>(doctorDTO2,HttpStatus.OK);
		}
		DoctorDTO doctorDTO2 = this.doctorConverter.convertEntityToDto(doctor);
		return new ResponseEntity<>(doctorDTO2, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PostMapping("/")
	public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO) throws DoctorNotFoundException {
		return this.doctorService.createDoctor(doctorDTO);
	}
	
	@GetMapping("/get-doctor/{doctorIdData}")
	public Doctor getDoctor(@PathVariable String doctorIdData) {
		return this.doctorService.findByDoctorId(doctorIdData);
	}
	
	@GetMapping("/get-doctor-list")
	public List<Doctor> getDoctorList(){
		return this.doctorService.getDoctorList();
	}
	
	@PutMapping("/update-doctor")
	public DoctorDTO updateDoctor(@RequestBody DoctorDTO doctorDTO) throws DoctorNotFoundException {
		Doctor doctor = this.doctorService.findByDoctorId(doctorDTO.getDoctorId());
		log.info(doctor);
		if(doctor==null) {
			throw new DoctorNotFoundException();
		}
		return this.doctorService.updateDoctor(doctorDTO);
	}
	
	@DeleteMapping("/delete-doctor/{doctorIdData}")
	@Transactional
	public String deleteDoctor(@PathVariable  String doctorIdData) {
		log.info("Doctor delete method "+doctorIdData);
		return this.doctorService.deleteDoctor(doctorIdData);
	}
}
