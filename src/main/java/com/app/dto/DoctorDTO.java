package com.app.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private String doctorId;
	private String doctorName;
	private String specialization;
	private String doctorPassword;
	private String doctorPhone;
	private String doctorEmail;
	private String doctorAddress;
	private String doctorImageUrl;
	private Integer slotSize;
}
