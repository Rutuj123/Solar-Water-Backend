package com.solar.DTO;

import java.time.LocalDate;

import com.solar.entity.Order;

public record InstallationDTO(Long id,LocalDate installationDate, String technicianName, String location,
		String status, String remarks, Order order) {
	 
}
