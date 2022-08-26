package com.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Slot;
import com.app.repo.SlotRepo;
import com.app.service.SlotService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SlotServiceImpl implements SlotService{
	
	
	@Autowired
	private SlotRepo slotRepo;
	
	@Override
	public Slot createSlot(Slot slotData) {
		Slot slot = null;
		if(getSlotCount(slotData.getDoctorId(), slotData.getSlotDate()) < 5) {
			log.error("slot available");
			log.error(slotData.getSlotDate());
			slot = this.slotRepo.save(slotData);
			log.error(getSlotCount(slotData.getDoctorId(), slotData.getSlotDate()) + "slots, create getSlot method called");
			return slot;
		}
		log.error("slots not available");
		return slot;
	}
	

	@Override
	public Slot getSlotById(String slotId) {
		return this.slotRepo.findBySlotId(slotId);
	}

	@Override
	public List<Slot> getSlotList() {
		 return this.slotRepo.findAll();
	}
	
	
	@Override
	public int getSlotCount(String doctorId, LocalDate slotDate) {
		int slots =  this.slotRepo.getSlotCount(doctorId, slotDate);
		log.error(slotDate + "service");
		return slots;
	}

	@Override
	public List<Slot> getSlotListByDoctorId(String doctorId){
		return this.slotRepo.findByDoctorId(doctorId);
	}

	@Override
	public Slot updateSlotPrescription(String slotId, String prescription){
		Slot slot = this.slotRepo.findBySlotId(slotId);
		slot.setPrescription(prescription);
		this.slotRepo.save(slot);
		return slot;
	}



}
