package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "slot_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"user","doctor"})
public class Slot {

	@Id
	private String slotId;
	private String patientName;
	private int patientAge;
	private LocalDate slotDate;
	private String doctorId;
	private String patientPhone;
	private String symptoms;
	private String prescription;

	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "userId")
	@JsonBackReference(value = "user-ref")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "doctorId")
	@JsonBackReference(value = "doctor-ref")
	private Doctor doctor;
	
}
