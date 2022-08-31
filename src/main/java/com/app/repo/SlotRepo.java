package com.app.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Slot;

@Repository
public interface SlotRepo extends JpaRepository<Slot, Long>{

	public Slot findBySlotId(String slotId);
	
	public List<Slot> findByDoctorId(String doctorId);

	@Query("SELECT count(*) FROM #{#entityName} where doctorId = :doctorId and slotDate = :slotDate")
	public int getSlotCount(@Param("doctorId") String doctorId,@Param("slotDate") LocalDate slotDate);

	public List<Slot> findAllByUserId(Long userId);

}