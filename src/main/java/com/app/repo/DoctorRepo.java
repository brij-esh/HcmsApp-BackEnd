package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String>{

	public Doctor findByDoctorId(String doctorId);

	public void deleteByDoctorId(String doctorIdD);
	
	@Query("SELECT slotSize FROM #{#entityName} where doctorId = :doctorId")
	public Integer findSlotSizeByDoctorId(@Param("doctorId") String doctorId);
}
