package com.solar.service;

import java.util.List;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solar.DTO.InstallationDTO;
import com.solar.entity.Installation;
import com.solar.repository.InstallationRepository;

@Service
public class InstallationService {
	@Autowired
	private  InstallationRepository installationRepository;

    public Installation saveInstallation(Installation installation) {
        return installationRepository.save(installation);
        		
    }

    public List<InstallationDTO> getAll() {
        return installationRepository.findAll()
        		.stream()
        		.map(installation-> new InstallationDTO(
        				installation.getId(), installation.getInstallationDate(), installation.getTechnicianName(),
        				installation.getLocation(), installation.getStatus(), installation.getRemarks(), installation.getOrder()
        		))
        		.toList();
    }

}
