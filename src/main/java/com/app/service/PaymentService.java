package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.PaymentDTO;
import com.app.entity.Payment;

public interface PaymentService {
    public PaymentDTO createPayment(PaymentDTO paymentDTO);

    public List<Payment> getPaymentList();

    public List<Payment> getPaymentListByDateRange(LocalDate startDate, LocalDate endDate);
}
