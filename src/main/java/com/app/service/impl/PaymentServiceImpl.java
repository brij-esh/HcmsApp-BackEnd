package com.app.service.impl;

import java.time.LocalDate;
import java.util.List;

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
        payment.setPaymentDate(LocalDate.now());
        this.paymentRepo.save(payment);
        return paymentDTO;
    }

    @Override
    public List<Payment> getPaymentList() {
        return this.paymentRepo.findAll();
    }

    @Override
    public List<Payment> getPaymentListByDateRange(LocalDate startDate, LocalDate endDate) {
        return this.paymentRepo.findByPaymentDateGreaterThanEqualAndPaymentDateLessThanEqual(startDate, endDate);
    }

    @Override
    public List<Payment> getPaymentListByDoctorIdAndDateRange(String doctorId, LocalDate startDate, LocalDate endDate) {
       return this.paymentRepo.findByDoctorIdAndPaymentDateGreaterThanEqualAndPaymentDateLessThanEqual(doctorId, startDate, endDate);
    }
    
}
