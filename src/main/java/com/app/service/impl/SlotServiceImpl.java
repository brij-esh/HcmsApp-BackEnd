package com.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Slot;
import com.app.repo.SlotRepo;
import com.app.service.SlotService;

import lombok.extern.java.Log;

@Service
public class SlotServiceImpl implements SlotService{
	
	
	@Autowired
	private SlotRepo slotRepo;
	
	@Override
	public Slot createSlot(Slot slotData) {
		Slot slot = null;
		if(getSlotCount(slotData.getDoctorId(), slotData.getSlotDate()) < 5) {
			System.out.println("slot available");
			System.out.println(slotData.getSlotDate());
			slot = this.slotRepo.save(slotData);
			System.out.println(getSlotCount(slotData.getDoctorId(), slotData.getSlotDate()) + "slots, create getSlot method called");
			return slot;
		}
		System.out.println("slots not available");
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
		System.out.println(slotDate + "service");
		return slots;
	}


}
