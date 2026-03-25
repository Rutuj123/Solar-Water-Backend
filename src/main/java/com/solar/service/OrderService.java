package com.solar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.solar.repository.OrderRepository;
import com.solar.repository.LeadRepository;
import com.solar.repository.QuotationRepository;
import com.solar.entity.Order;
import com.solar.entity.Lead;
import com.solar.entity.Quotation;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;
    
    @Autowired
    private  LeadRepository enquiryRepository;
    
    @Autowired
    private  QuotationRepository quotationRepository;

    public Order createOrder(Long enquiryId, Long quotationId) {

        Lead enquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(() -> new RuntimeException("Enquiry Not Found"));

        Quotation quotation = quotationRepository.findById(quotationId)
                .orElseThrow(() -> new RuntimeException("Quotation Not Found"));

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setGrandTotal(quotation.getTotalAmount());
        order.setStatus("CONFIRMED");
        order.setEnquiry(enquiry);
        order.setQuotation(quotation);

        enquiry.setStatus("CONVERTED");
        enquiryRepository.save(enquiry);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
   
    public void deleteOrder(Long id) {
    	 orderRepository.deleteById(id);
    }

}