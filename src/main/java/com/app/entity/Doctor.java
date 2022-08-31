package com.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="doctor_table")
@Getter
@Setter
@ToString(exclude = "slots")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
	private String doctorId;
	private String doctorName;
	private String specialization;
	private String doctorPassword;
	private String doctorPhone;
	private String doctorEmail;
	private String doctorAddress;
	private String doctorImageUrl;
	
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	@JsonManagedReference(value = "doctor-ref")
	private Set<Slot> slots = new HashSet<>();
}
