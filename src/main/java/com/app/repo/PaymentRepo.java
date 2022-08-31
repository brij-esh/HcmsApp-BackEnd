package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
    
}