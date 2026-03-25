package com.solar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solar.entity.Product;
import com.solar.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
    
	@Autowired
	private ProductService productService;	
	
	 @GetMapping
	 public ResponseEntity<List<Product>> getAllProducts() {
		 List<Product> list= productService.getAllProducts();
	       return ResponseEntity.ok(list);
	    }
	 
	
}
