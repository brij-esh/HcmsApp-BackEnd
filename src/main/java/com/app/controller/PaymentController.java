package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentDTO;
import com.app.entity.Payment;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:4200")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO){
        PaymentDTO payment = this.paymentService.createPayment(paymentDTO);
        return new ResponseEntity<>(payment,HttpStatus.OK);
    }

    @GetMapping("/getPaymentList")
    public ResponseEntity<List<Payment>> getPaymentList(){
        List<Payment> payments = this.paymentService.getPaymentList();
        return new ResponseEntity<>(payments,HttpStatus.OK);
    }

    @GetMapping("/getPaymentListByDateRange")
    public ResponseEntity<List<Payment>> getPaymentListByDateRange(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        List<Payment> payments = this.paymentService.getPaymentListByDateRange(startDate, endDate);
        return new ResponseEntity<>(payments,HttpStatus.OK);
    }
    @GetMapping("/getPaymentListByDoctorIdAndDateRange/{doctorId}")
    public ResponseEntity<List<Payment>> getPaymentListByDoctorIdAndDateRange(@PathVariable String doctorId, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        List<Payment> payments = this.paymentService.getPaymentListByDoctorIdAndDateRange(doctorId, startDate, endDate);
        return new ResponseEntity<>(payments,HttpStatus.OK);
    }
}
