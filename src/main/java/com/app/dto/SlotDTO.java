package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Doctor;
import com.app.entity.User;

import lombok.Data;

@Data
public class SlotDTO {
    private String slotId;
	private String patientName;
	private int patientAge;
	private LocalDate slotDate;
	private String doctorId;
	private String patientPhone;
	private String symptoms;
	private String prescription;
    private Doctor doctor;
    private User user;
	private boolean status;
}
