package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cardType;
	private String cardNo;
	private String cardHolderName;
	private String expiry;
	private String cvv;
    private Double fees;
    
}
