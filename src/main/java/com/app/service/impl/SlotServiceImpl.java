package com.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Slot;
import com.app.repo.SlotRepo;
import com.app.service.SlotService;

@Service
public class SlotServiceImpl implements SlotService{
	
	
	@Autowired
	private SlotRepo slotRepo;
	
	@Override
	public Slot createSlot(Slot slot) {
		if(getSlotCount(slot.getDoctorId(), slot.getSlotDate()) < 5) {
			System.out.println("slot available");
//			System.out.println(slot.getSlotDate());
			System.out.println(getSlotCount(slot.getDoctorId(), slot.getSlotDate()) + " create getSlot method");
			return this.slotRepo.save(slot);
		}
		System.out.println("slots not available");
		return null;
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
		return slots;
	}

}
