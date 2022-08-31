package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Pharmacy;
import com.app.repo.PharmacyRepo;
import com.app.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService{

	@Autowired
	private PharmacyRepo pharmacyRepo;

	@Override
	public Pharmacy createPharmacy(Pharmacy pharmacyData) throws Exception {
		Pharmacy pharmacy = this.pharmacyRepo.findByPharmacyId(pharmacyData.getPharmacyId());
		String generatedPharmacyId = "";
		if(pharmacy!=null){
			generatedPharmacyId += pharmacyData.getPharmacyName().substring(0,3).concat(pharmacyData.getPharmacyPhone().substring(1,3));
		}else{
			generatedPharmacyId += pharmacyData.getPharmacyName().substring(0,3).concat(pharmacyData.getPharmacyPhone().substring(0,3));
		}
		try {
			pharmacyData.setPharmacyId(generatedPharmacyId);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return this.pharmacyRepo.save(pharmacyData);
	}


	@Override
	public Pharmacy findByPharmacyId(String pharmacyIdData) {
		return this.pharmacyRepo.findByPharmacyId(pharmacyIdData);
	}
	
	@Override
	public Pharmacy updatePharmacy(Pharmacy pharmacyData) {
		Pharmacy pharmacy = this.pharmacyRepo.findByPharmacyId(pharmacyData.getPharmacyId());
		pharmacy.setPharmacyEmail(pharmacyData.getPharmacyEmail());
		pharmacy.setPharmacyId(pharmacyData.getPharmacyId());
		pharmacy.setPharmacyName(pharmacyData.getPharmacyName());
		pharmacy.setPharmacyOwner(pharmacyData.getPharmacyOwner());
		pharmacy.setPharmacyPassword(pharmacyData.getPharmacyPassword());
		pharmacy.setPharmacyPhone(pharmacyData.getPharmacyPhone());
		this.pharmacyRepo.save(pharmacy);
		return pharmacy;
	}


	@Override
	public List<Pharmacy> getPharmacyList() {
		return this.pharmacyRepo.findAll();
	}
	
	
	@Override
	public String deletePharmacy(String pharmacyIdData) {
		this.pharmacyRepo.deleteByPharmacyId(pharmacyIdData);
		return pharmacyIdData+"\nDeleted Pharmacy!!";
	}



}
