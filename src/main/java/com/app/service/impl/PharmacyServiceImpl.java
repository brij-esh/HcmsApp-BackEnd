package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.PharmacyConverter;
import com.app.dto.PharmacyDTO;
import com.app.entity.Pharmacy;
import com.app.exception.PharmacyNotFoundException;
import com.app.repo.PharmacyRepo;
import com.app.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService{

	@Autowired
	private PharmacyRepo pharmacyRepo;

	@Autowired
	private PharmacyConverter pharmacyConverter;


	@Override
	public PharmacyDTO createPharmacy(PharmacyDTO pharmacyDTO) throws PharmacyNotFoundException {

		Pharmacy pharmacy = this.pharmacyRepo.findByPharmacyId(this.pharmacyConverter.convertDtoToEntity(pharmacyDTO).getPharmacyId());
		String generatedPharmacyId = "";
		if(pharmacy!=null){
			generatedPharmacyId += pharmacyDTO.getPharmacyName().substring(0,3).concat(pharmacyDTO.getPharmacyPhone().substring(1,3));
		}else{
			generatedPharmacyId += pharmacyDTO.getPharmacyName().substring(0,3).concat(pharmacyDTO.getPharmacyPhone().substring(0,3));
		}
		pharmacyDTO.setPharmacyId(generatedPharmacyId);
		pharmacy = this.pharmacyConverter.convertDtoToEntity(pharmacyDTO);
		this.pharmacyRepo.save(pharmacy);
		return pharmacyDTO;
	}


	@Override
	public Pharmacy findByPharmacyId(String pharmacyIdData) {
		return this.pharmacyRepo.findByPharmacyId(pharmacyIdData);
	}
	
	@Override
	public PharmacyDTO updatePharmacy(PharmacyDTO pharmacyDTO) {
		Pharmacy pharmacy = this.pharmacyRepo.findByPharmacyId(pharmacyDTO.getPharmacyId());
		pharmacy.setPharmacyEmail(pharmacyDTO.getPharmacyEmail());
		pharmacy.setPharmacyId(pharmacyDTO.getPharmacyId());
		pharmacy.setPharmacyName(pharmacyDTO.getPharmacyName());
		pharmacy.setPharmacyOwner(pharmacyDTO.getPharmacyOwner());
		pharmacy.setPharmacyPassword(pharmacyDTO.getPharmacyPassword());
		pharmacy.setPharmacyPhone(pharmacyDTO.getPharmacyPhone());
		this.pharmacyRepo.save(pharmacy);
		return this.pharmacyConverter.convertEntityToDto(pharmacy);
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
