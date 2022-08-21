package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Slot;
import com.app.service.SlotService;

@RestController
@RequestMapping("/slot")
@CrossOrigin("http://localhost:4200")
public class SlotController {
	
	
	@Autowired
	private SlotService slotService;
	
	@PostMapping("/create-slot")
	public Slot createSlot(@RequestBody Slot slot) {
		return this.slotService.createSlot(slot);
	}
	
	
	@GetMapping("/get-slot/{slotIdData}")
	public Slot getSlot(@PathVariable String slotIdData) {
		return this.slotService.getSlotById(slotIdData);
	}
	
	@GetMapping("/get-slot-list")
	public List<Slot> getSlotList(){
		return this.slotService.getSlotList();
	}
	
	
	@GetMapping("/get-slot-count/{doctorIdData}/{slotDate}")
	public int getSlotCount(@PathVariable("doctorIdData") String doctorIdData, LocalDate slotDate) {
		int slots = this.slotService.getSlotCount(doctorIdData, slotDate);
		System.out.println("Controller: " +slots);
		System.out.println(doctorIdData);
		System.out.println(slotDate);
		return slots;
	}
	
	@GetMapping("/download/{slotId}")
	public String getSlotPrescription(@PathVariable String slotIdData) {
		Slot slot = this.slotService.getSlotById(slotIdData);
		return slot.getPrescription();
	}

}
