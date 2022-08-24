package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Slot;
import com.app.service.SlotService;

import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping("/slot")
@CrossOrigin("http://localhost:4200")
@Log4j2
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
	
	
	@GetMapping("/get-slot-count/{doctorIdData}")
	public int getSlotCount(@PathVariable("doctorIdData") String doctorIdData, @RequestParam("slotDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate slotDate) {
		int slots = this.slotService.getSlotCount(doctorIdData, slotDate);
		log.error("Controller"+slots);
		log.error(doctorIdData);
		log.error(slotDate);
		return slots;
	}
	
	@GetMapping("/download/{slotId}")
	public String getSlotPrescription(@PathVariable String slotIdData) {
		Slot slot = this.slotService.getSlotById(slotIdData);
		return slot.getPrescription();
	}

	@GetMapping("/get-slot-list-by-doctor-id/{doctorIdData}")
	public List<Slot> getSlotListByDoctorId(@PathVariable String doctorIdData){
		return this.slotService.getSlotListByDoctorId(doctorIdData);
	}

	@PutMapping("/update-slot/{slotId}")
	public Slot updateSlot(@PathVariable String slotId, @RequestBody String prescription){
		System.out.println(slotId + prescription);
		return this.slotService.updateSlotPrescription(slotId, prescription);
	}

}
