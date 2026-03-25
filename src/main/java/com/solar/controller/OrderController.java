
package com.solar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.solar.service.OrderService;
import com.solar.entity.Order;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
     
	@Autowired
    private  OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestParam Long enquiryId,
                             @RequestParam Long quotationId) {
        return orderService.createOrder(enquiryId, quotationId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
    	orderService.deleteOrder(id);
    }

}