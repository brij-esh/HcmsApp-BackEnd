package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Payment;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:4200")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment paymentData){
        Payment payment = this.paymentService.createPayment(paymentData);
        return ResponseEntity.ok(payment);
    }
}
