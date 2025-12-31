package com.example.hospital_management.controller;

import com.example.hospital_management.dto.PatientDto;
import com.example.hospital_management.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable Long id) {
        PatientDto patientDto = patientService.getById(id);
        return ResponseEntity.ok(patientDto);
    }
}
