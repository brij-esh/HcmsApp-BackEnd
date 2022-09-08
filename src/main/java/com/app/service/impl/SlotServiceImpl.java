package com.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.SlotConverter;
import com.app.dto.SlotDTO;
import com.app.entity.Slot;
import com.app.repo.SlotRepo;
import com.app.service.SlotService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SlotServiceImpl implements SlotService{
	
	
	@Autowired
	private SlotRepo slotRepo;

	@Autowired
	private SlotConverter slotConverter;
	
	@Override
	public SlotDTO createSlot(SlotDTO slotDTO) {
		Slot slot;
		if(getSlotCount(slotDTO.getDoctorId(), slotDTO.getSlotDate()) < 5) {
			slotDTO.setSlotId(generateSlotId(slotDTO.getPatientName(),slotDTO.getSlotDate(),slotDTO.getDoctorId()));
			log.error("slot available");
			log.error(slotDTO.getSlotDate());
			log.error(slotDTO);
			slot =this.slotRepo.save(this.slotConverter.convertDtoToEntity(slotDTO));
			log.error(getSlotCount(slotDTO.getDoctorId(), slotDTO.getSlotDate()) + "slots, create getSlot method called");
			return this.slotConverter.convertEntityToDto(slot);
		}
		log.error("slots not available");
		return null;
	}

	public String generateSlotId(String patientName, LocalDate date,String doctorId){
		return patientName.substring(0,4).concat(doctorId.substring(0,3)).concat(date.toString().substring(4,7));
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
	public Slot updateSlot(Slot slotData){
		Slot slot = this.slotRepo.findBySlotId(slotData.getSlotId());
		slot.setDoctor(slotData.getDoctor());
		slot.setDoctorId(slotData.getDoctorId());
		slot.setPatientAge(slotData.getPatientAge());
		slot.setPatientName(slotData.getPatientName());
		slot.setPatientPhone(slotData.getPatientPhone());
		slot.setPrescription(slotData.getPrescription());
		slot.setSlotDate(slotData.getSlotDate());
		slot.setSymptoms(slotData.getSymptoms());
		slot.setUser(slotData.getUser());
		return this.slotRepo.save(slot);
	}


}
