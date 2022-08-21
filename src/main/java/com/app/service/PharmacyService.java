package com.app.service;

import java.util.List;

import com.app.entity.Pharmacy;



public interface PharmacyService {

	public Pharmacy createPharmacy(Pharmacy pharmacy) throws Exception;

	public Pharmacy findByPharmacyId(String pharmacyIdData);
	
	public Pharmacy updatePharmacy(Pharmacy pharmacyData);
	
	public List<Pharmacy> getPharmacyList();
	
	public String deletePharmacy(String pharmacyIdData);
	

	
}
