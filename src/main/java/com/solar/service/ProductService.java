package com.solar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.solar.entity.Product;


public interface ProductService {
	List<Product> getAllProducts();
    Product saveProduct(Product product);
}
