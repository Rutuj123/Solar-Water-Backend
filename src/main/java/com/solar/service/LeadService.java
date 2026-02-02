package com.solar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solar.entity.Lead;
import com.solar.repository.LeadRepository;

@Service
public class LeadService {
	@Autowired
    private LeadRepository leadRepository;

    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

}
