package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.solar.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}