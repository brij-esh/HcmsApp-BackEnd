package com.app.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Slot;

@Repository
public interface SlotRepo extends JpaRepository<Slot, String>{

	public Slot findBySlotId(String slotId);
	
	@Query("SELECT count(*) FROM #{#entityName} where doctorId = :doctorId and slotDate = :slotDate")
	public int getSlotCount(@Param("doctorId") String doctorId,@Param("slotDate") LocalDate slotdate);

}