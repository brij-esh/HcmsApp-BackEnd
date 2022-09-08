package com.app.service;

import java.util.List;

import com.app.dto.PharmacyDTO;
import com.app.entity.Pharmacy;
import com.app.exception.PharmacyNotFoundException;



public interface PharmacyService {

	public PharmacyDTO createPharmacy(PharmacyDTO pharmacyDTO) throws PharmacyNotFoundException;

	public Pharmacy findByPharmacyId(String pharmacyIdData);
	
	public PharmacyDTO updatePharmacy(PharmacyDTO pharmacyDTO);
	
	public List<Pharmacy> getPharmacyList();
	
	public String deletePharmacy(String pharmacyIdData);
	

	
}
