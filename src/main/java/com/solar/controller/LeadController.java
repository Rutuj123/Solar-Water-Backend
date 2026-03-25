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

import com.solar.entity.Lead;
import com.solar.service.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
	@Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity<Lead> c(@RequestBody Lead lead) {
        return ResponseEntity.ok(leadService.saveLead(lead));
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getLeads() {
    	List<Lead> list=leadService.getAllLeads();
         return ResponseEntity.ok(list);
    }
  
}
