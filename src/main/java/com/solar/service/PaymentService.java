package com.solar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solar.repository.PaymentRepository;
import com.solar.repository.OrderRepository;
import com.solar.entity.Payment;
import com.solar.entity.Order;

import java.util.List;

@Service
public class PaymentService {
     @Autowired
    private  PaymentRepository paymentRepository;
     
     @Autowired
    private  OrderRepository orderRepository;

    public Payment savePayment(Payment payment) {

        Order order = orderRepository.findById(payment.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        payment.setOrder(order);

        Payment savedPayment = paymentRepository.save(payment);

        // 🔥 Business Logic: Update Order Status
        double totalPaid = order.getPayments()
                .stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        if (totalPaid >= order.getGrandTotal()) {
            order.setStatus("PAID");
        } else {
            order.setStatus("PARTIAL");
        }

        orderRepository.save(order);

        return savedPayment;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}