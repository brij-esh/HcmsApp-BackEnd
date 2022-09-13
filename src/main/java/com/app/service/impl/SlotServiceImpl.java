package com.app.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.SlotConverter;
import com.app.dto.SlotDTO;
import com.app.entity.Doctor;
import com.app.entity.Slot;
import com.app.entity.User;
import com.app.repo.DoctorRepo;
import com.app.repo.SlotRepo;
import com.app.service.SlotService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SlotServiceImpl implements SlotService{
	
	
	@Autowired
	private SlotRepo slotRepo;

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private SlotConverter slotConverter;

	
	@Override
	public SlotDTO createSlot(SlotDTO slotDTO) throws NoSuchAlgorithmException {
		Slot slot;
		Integer slotSize = this.doctorRepo.findSlotSizeByDoctorId(slotDTO.getDoctorId());
		if(getSlotCount(slotDTO.getDoctorId(), slotDTO.getSlotDate()) < slotSize) {
			slotDTO.setSlotId(generateSlotId(slotDTO.getPatientName(),slotDTO.getSlotDate(),slotDTO.getDoctorId()));
			log.error("slot available");
			log.error(slotDTO.getSlotDate());
			log.error(slotDTO);
			slot =this.slotRepo.save(this.slotConverter.convertDtoToEntity(slotDTO));
			log.error(getSlotCount(slotDTO.getDoctorId(), slotDTO.getSlotDate()) + " slots, create getSlot method called");
			return this.slotConverter.convertEntityToDto(slot);
		}
		log.error("slots not available");
		return null;
	}

	public String generateSlotId(String patientName, LocalDate date,String doctorId) throws NoSuchAlgorithmException{
		Random rand = SecureRandom.getInstanceStrong();
		return patientName.substring(0,3).concat(doctorId.substring(0,3)).concat(date.toString().substring(5,7).concat(Integer.toString((rand.nextInt()*patientName.length())/100000)));
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


	@Override
	public List<Slot> getSlotListByUserId(Long userId) {
		return this.slotRepo.findAllByUserId(userId);
	}

	@Override
	public SlotDTO updateSlot(SlotDTO slotDTO){
		Slot slot = this.slotRepo.findBySlotId(slotDTO.getSlotId());
		Doctor doctor = slot.getDoctor();
		User user = slot.getUser();
		slot.setDoctor(slotDTO.getDoctor());
		slot.setDoctorId(slotDTO.getDoctorId());
		slot.setPatientAge(slotDTO.getPatientAge());
		slot.setPatientName(slotDTO.getPatientName());
		slot.setPatientPhone(slotDTO.getPatientPhone());
		slot.setPrescription(slotDTO.getPrescription());
		slot.setSlotDate(slotDTO.getSlotDate());
		slot.setSymptoms(slotDTO.getSymptoms());
		slot.setUser(slotDTO.getUser());
		slot.setDoctor(doctor);
		slot.setUser(user);
		this.slotRepo.save(slot);
		return this.slotConverter.convertEntityToDto(slot);
	}

	@Override
	public String deleteSlot(String slotId) {
		Slot slot = this.slotRepo.findBySlotId(slotId);
		this.slotRepo.delete(slot);
		return slotId + "deleted successfully";
	}


}
