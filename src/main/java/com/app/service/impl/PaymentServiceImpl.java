package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.PaymentConverter;
import com.app.dto.PaymentDTO;
import com.app.entity.Payment;
import com.app.repo.PaymentRepo;
import com.app.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private PaymentConverter paymentConverter;

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = this.paymentConverter.convertDtoToEntity(paymentDTO);
        this.paymentRepo.save(payment);
        return paymentDTO;
    }
    
}
