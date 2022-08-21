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
	public Pharmacy createPharmacy(Pharmacy pharmacy) throws Exception {
		Pharmacy pharm = this.pharmacyRepo.findByPharmacyId(pharmacy.getPharmacyId());
		if(pharm!=null) {
			System.out.println("Pharmacy Already Present with pharmacy id: "+pharmacy.getPharmacyId());
			throw new Exception("Pharmacy Already Present with pharmacy id: "+pharmacy.getPharmacyId());
		}else {
			pharm = this.pharmacyRepo.save(pharmacy);
		}
		return pharm;
	}


	@Override
	public Pharmacy findByPharmacyId(String pharmacyIdData) {
		Pharmacy pharm = this.pharmacyRepo.findByPharmacyId(pharmacyIdData);
		return pharm;
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
//		this.pharmacyRepo.delete(this.pharmacyRepo.findByPharmacyId(pharmacyIdData));
		this.pharmacyRepo.deleteByPharmacyId(pharmacyIdData);
		return pharmacyIdData+"\nDeleted Pharmacy!!";
	}



}
