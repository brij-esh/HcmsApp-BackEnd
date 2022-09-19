package com.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long id;
	private String cardType;
	private String cardNo;
	private String cardHolderName;
	private String expiry;
	private String cvv;
    private Double amount;
	private LocalDate paymentDate;
	private Long userId;
	private String doctorId;
}
