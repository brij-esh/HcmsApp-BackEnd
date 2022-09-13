package com.app.service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

import com.app.dto.SlotDTO;
import com.app.entity.Slot;

public interface SlotService {
	
	public SlotDTO createSlot(SlotDTO slotDTO) throws NoSuchAlgorithmException;
	
	public Slot getSlotById(String slotId);
	
	public List<Slot> getSlotList();

	public int getSlotCount(String doctorId, LocalDate slotDate);

	public List<Slot> getSlotListByDoctorId(String doctorId);

	public Slot updateSlotPrescription(String slotId, String prescription);

	public List<Slot> getSlotListByUserId(Long userId);

	public SlotDTO updateSlot(SlotDTO slotDTO);

	public String deleteSlot(String slotId);
}
