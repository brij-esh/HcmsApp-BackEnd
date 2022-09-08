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

import com.app.converter.PharmacyConverter;
import com.app.dto.PharmacyDTO;
import com.app.entity.Pharmacy;
import com.app.exception.PharmacyNotFoundException;
import com.app.service.PharmacyService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin("http://localhost:4200")
@Log4j2
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService;

	@Autowired
	private PharmacyConverter pharmacyConverter;
	
	@PostMapping("/login")
	public ResponseEntity<PharmacyDTO> loginPharmacy(@RequestBody PharmacyDTO pharmacyDTO){
		Pharmacy pharmacy = this.pharmacyService.findByPharmacyId(pharmacyDTO.getPharmacyId());
		if(pharmacy.getPharmacyPassword().equals(pharmacyDTO.getPharmacyPassword())) {
			PharmacyDTO pharmacyDTO2 = this.pharmacyConverter.convertEntityToDto(pharmacy);
			return new ResponseEntity<>(pharmacyDTO2,HttpStatus.OK);
		}
		PharmacyDTO pharmacyDTO2 = this.pharmacyConverter.convertEntityToDto(pharmacy);
		return new ResponseEntity<>(pharmacyDTO2, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
//	creating pharmacy
	@PostMapping("/")
	public PharmacyDTO createPharmacy(@RequestBody PharmacyDTO pharmacyDTO) throws PharmacyNotFoundException {
		return this.pharmacyService.createPharmacy(pharmacyDTO);
	}
	
	@GetMapping("/get-pharmacy/{pharmacyIdData}")
	public Pharmacy getPharmacy(@PathVariable String pharmacyIdData) {
		return this.pharmacyService.findByPharmacyId(pharmacyIdData);
	}
	@GetMapping("/get-pharmacy-list")
	public List<Pharmacy> getPharmacyList(){
		return this.pharmacyService.getPharmacyList();
	}
	

	@PutMapping("/update-pharmacy")
	public PharmacyDTO updatePharmacy(@RequestBody PharmacyDTO pharmacyDTO) throws PharmacyNotFoundException {
		Pharmacy pharmacy = this.pharmacyService.findByPharmacyId(pharmacyDTO.getPharmacyId());
		log.info(pharmacy);
		if(pharmacy==null) {
			throw new PharmacyNotFoundException();
		}
		return this.pharmacyService.updatePharmacy(pharmacyDTO);
	}
	
	@DeleteMapping("/delete-pharmacy/{pharmacyIdData}")
	@Transactional
	public String deletePharmacy(@PathVariable  String pharmacyIdData) {
		log.info("Pharmacy deleted"+pharmacyIdData);
		return this.pharmacyService.deletePharmacy(pharmacyIdData);
	}
	
	
}
