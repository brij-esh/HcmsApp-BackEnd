package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Payment;
import com.app.repo.PaymentRepo;
import com.app.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment createPayment(Payment payment) {
       return this.paymentRepo.save(payment);
    }
    
}
