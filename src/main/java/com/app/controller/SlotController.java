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

import com.app.entity.Doctor;
import com.app.entity.Slot;
import com.app.entity.User;
import com.app.service.DoctorService;
import com.app.service.SlotService;
import com.app.service.UserService;

import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping("/slot")
@CrossOrigin("http://localhost:4200")
@Log4j2
public class SlotController {
	
	
	@Autowired
	private SlotService slotService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private UserService userService;

	
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
		log.error(slotId + prescription);
		return this.slotService.updateSlotPrescription(slotId, prescription);
	}

	@GetMapping("/get-slot-list-by-user-id/{userIdData}")
	public List<Slot> getSlotListByUserId(@PathVariable Long userIdData){
		return this.slotService.getSlotListByUserId(userIdData);
	}

	@PutMapping("/{slotId}/doctor/{doctorId}")
	public Slot bookSlot(@PathVariable String slotId,@PathVariable String doctorId){
		Doctor doctor = this.doctorService.findByDoctorId(doctorId);
		Slot slot = this.slotService.getSlotById(slotId);
		slot.assignDoctor(doctor);
		return this.slotService.updateSlot(slot);
	}

	@PutMapping("/{slotId}/user/{userId}")
	public Slot bookUser(@PathVariable Long userId,@PathVariable String slotId){
		User user = this.userService.getUserById(userId);
		Slot slot = this.slotService.getSlotById(slotId);
		slot.assignUser(user);
		return this.slotService.updateSlot(slot);
	}

}
