package com.app.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Payment;


@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
    List<Payment> findByPaymentDate(LocalDate paymentDate);
    List<Payment> findByPaymentDateGreaterThanEqualAndPaymentDateLessThanEqual(LocalDate startDate, LocalDate endDate);
}
