package com.app.controller;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Pharmacy;
import com.app.service.PharmacyService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin("http://localhost:4200")
@Log4j2
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService;
	
	
//	creating pharmacy
	@PostMapping("/")
	public Pharmacy createPharmacy(@RequestBody Pharmacy pharmacyData) throws Exception {
		return this.pharmacyService.createPharmacy(pharmacyData);
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
	public Pharmacy updatePharmacy(@RequestBody Pharmacy pharmacyData) {
		Pharmacy pharmacy = this.pharmacyService.findByPharmacyId(pharmacyData.getPharmacyId());
		if(pharmacy!=null) {
			this.pharmacyService.updatePharmacy(pharmacyData);
		}
		return pharmacy;
	}
	
	@DeleteMapping("/delete-pharmacy/{pharmacyIdData}")
	@Transactional
	public String deletePharmacy(@PathVariable  String pharmacyIdData) {
		log.error("Pharmacy deleted"+pharmacyIdData);
		return this.pharmacyService.deletePharmacy(pharmacyIdData);
	}
	
	
}
