package com.app.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.entity.Doctor;
import com.app.service.DoctorService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("http://localhost:4200")
@Log4j2
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/login")
	public ResponseEntity<Doctor> loginDoctor(@RequestBody Doctor doctorData){
		Doctor doctor = this.doctorService.findByDoctorId(doctorData.getDoctorId());
		if(doctor.getDoctorPassword().equals(doctorData.getDoctorPassword())) {
			return ResponseEntity.ok(doctor);
		}
		return (ResponseEntity<Doctor>) ResponseEntity.internalServerError();
		
	}
	
	@PostMapping("/")
	public Doctor createDoctor(@RequestBody Doctor doctorData) throws Exception {
		return this.doctorService.createDoctor(doctorData);
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
	public Doctor updateDoctor(@RequestBody Doctor doctorData) {
		Doctor doctor = this.doctorService.findByDoctorId(doctorData.getDoctorId());
		log.error(doctor);
		if(doctor!=null) {
			this.doctorService.updateDoctor(doctorData);
		}
		return doctor;
	}
	
	@DeleteMapping("/delete-doctor/{doctorIdData}")
	@Transactional
	public String deleteDoctor(@PathVariable  String doctorIdData) {
		log.error("Doctor delete method "+doctorIdData);
		return this.doctorService.deleteDoctor(doctorIdData);
	}
}
