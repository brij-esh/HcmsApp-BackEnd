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

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin("http://localhost:4200")
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService;
	
	
//	creating pharmacy
	@PostMapping("/")
	public Pharmacy createPharmacy(@RequestBody Pharmacy pharmacyData) throws Exception {
		Pharmacy pharm = this.pharmacyService.createPharmacy(pharmacyData);
		return pharm;
	}
	
	@GetMapping("/get-pharmacy/{pharmacyIdData}")
	public Pharmacy getPharmacy(@PathVariable String pharmacyIdData) {
		Pharmacy pharmacy = this.pharmacyService.findByPharmacyId(pharmacyIdData);
		return pharmacy;
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
		System.out.println("Pharmacy delete method "+pharmacyIdData);
		
		return this.pharmacyService.deletePharmacy(pharmacyIdData);
	}
	
	
}
