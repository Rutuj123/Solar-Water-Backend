package com.solar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solar.DTO.AuthRequest;
import com.solar.DTO.AuthResponse;
import com.solar.DTO.ProductRequest;
import com.solar.config.JwtUtil;
import com.solar.entity.Lead;
import com.solar.entity.Product;
import com.solar.service.LeadService;
import com.solar.service.ProductService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
private AuthenticationManager authManager;

	@Autowired
private JwtUtil jwtUtil;

@Autowired	
private LeadService leadService;

@Autowired
private ProductService productService;
	
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
		String token="";
		try {
		System.out.println("in login......................");
		
		//String encodedPassword = passwordEncoder.encode("admin123");
	//System.out.println("encodedPassword..............."+encodedPassword);
		
		authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),
                		request.getPassword()
                		)
				);
		token=jwtUtil.generateToken(request.getUsername(), "ADMIN");
		
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity
		            .status(401)
		            .body(null);
		}
		return ResponseEntity.ok(new AuthResponse(token));
	}
	
	@GetMapping("/getAllLeads")
	public ResponseEntity<List<Lead>> getAllLeads(){
		List<Lead> listLeads=leadService.getAllLeads();
		return ResponseEntity.ok(listLeads);
	}
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveproduct(@RequestBody ProductRequest request) {
		Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
       // product.setDescription(request.getDescription());
        product.setCapacityLph(request.getCapacityLph());
        product.setFiltrationType(request.getFiltrationType());
       // product.setSolarSupported(request.getSolarSupported());
        //product.setStatus(request.getStatus());
        Product p=productService.saveProduct(product);
			return ResponseEntity.ok(p);
			
	} 
	@PutMapping("/products")
	public ResponseEntity<Product> editproduct(@RequestBody ProductRequest request) {
		Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
       // product.setDescription(request.getDescription());
        product.setCapacityLph(request.getCapacityLph());
        product.setFiltrationType(request.getFiltrationType());
       // product.setSolarSupported(request.getSolarSupported());
        //product.setStatus(request.getStatus());
        Product p=productService.saveProduct(product);
			return ResponseEntity.ok(p);
			
	} 
}
