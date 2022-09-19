package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Pharmacy;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, String>{
	public Pharmacy findByPharmacyId(String pharmacyId);
	public void deleteByPharmacyId(String pharmacyIdData);
	

}
