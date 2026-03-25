package com.solar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solar.DTO.QuotationResponseDTO;
import com.solar.entity.Quotation;
import com.solar.service.QuotationService;

@RestController
@RequestMapping("/api/quotations")
@CrossOrigin(origins = "http://localhost:4200")
public class QuotationController {
	 @Autowired
	    private QuotationService service;

	    @PostMapping
	    public ResponseEntity<QuotationResponseDTO> saveQuotation(@RequestBody Quotation quotation) {
	         Quotation quot=service.saveQuotation(quotation);
	         QuotationResponseDTO dto=new QuotationResponseDTO();
	         dto.setId(quot.getId());
	         dto.setTotalAmount(quot.getTotalAmount());
	         dto.setQuotationNumber(quot.getQuotationNumber());
	         return ResponseEntity.ok(dto);
	         
	    }
	    
	    @GetMapping
	    public ResponseEntity< List<Quotation>> getAllQuotation() {
	         List<Quotation> quot=service.getAllQuotation();
	        return ResponseEntity.ok(quot);
	         
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Map<String,String>> deleteQuotation(@PathVariable Long id) {
	    	System.out.println("in delete quotation..");
	    	 service.deleteQuotation(id);
	    	 Map<String,String> response=new HashMap<>();
	    	 response.put("message", "Quotation deleted successfully");
	    	 return ResponseEntity.ok(response);
	         
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<Quotation> updateQuotation(@PathVariable Long id,@RequestBody Quotation quotation) {
	    	Quotation quot=service.updateQuotation(id, quotation);
	    	 return ResponseEntity.ok(quot);
	         
	    }
	    
} 
	   
