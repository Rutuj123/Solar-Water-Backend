package com.solar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solar.DTO.InstallationDTO;
import com.solar.entity.Installation;
import com.solar.service.InstallationService;

@RestController
@RequestMapping("/api/installations")
public class InstallationController {
	private InstallationService installationService;

    @PostMapping
    public Installation createInstallation(@RequestBody Installation installation) {
        return installationService.saveInstallation(installation);
    }

    @GetMapping
    public List<InstallationDTO> getAllInstallations() {
        return installationService.getAll();
    }
}
