package com.example.hospital_management.controller;

import com.example.hospital_management.dto.BloodGroupResponseEntity;
import com.example.hospital_management.dto.PatientDto;
import com.example.hospital_management.entity.type.BloodGroup;
import com.example.hospital_management.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/name")
    public ResponseEntity<PatientDto> getByName(@RequestParam(value = "name") String name) {
        PatientDto patientDto = patientService.getByName(name);
        return ResponseEntity.ok(patientDto);
    }

    @GetMapping("/birthDateOrEmail")
    public ResponseEntity<List<PatientDto>> getByBirthdateOrEmail(@RequestParam(value = "birthDate") LocalDate birthDate, @RequestParam(value = "email") String email) {
        List<PatientDto> patientDtos = patientService.getByBirthdateorEmail(birthDate, email);
        return ResponseEntity.ok(patientDtos);
    }

    @GetMapping("/bloodGroup")
    public ResponseEntity<List<PatientDto>> getByBloodGroup(@RequestParam(value="bloodGroup")BloodGroup bloodGroup) {
        List<PatientDto> patientDtos = patientService.getByBloodGroup(bloodGroup);
        return ResponseEntity.ok(patientDtos);
    }

    @GetMapping("/bornAfterDate")
    public ResponseEntity<List<PatientDto>> getByBornAfterDate(@RequestParam(value="birthDate")LocalDate birthDate) {
        List<PatientDto> patientDtos = patientService.getByBornAfterDate(birthDate);
        return ResponseEntity.ok(patientDtos);
    }

    @GetMapping("/countBloodGroups")
    public ResponseEntity<List<BloodGroupResponseEntity>> countByBloodGroup() {
        List<BloodGroupResponseEntity> countGroups = patientService.countByBloodGroup();
        return ResponseEntity.ok(countGroups);
    }

    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<List<PatientDto>> getAllByPage(@PathVariable(value = "pageNumber") int pageNumber, @PathVariable(value = "pageSize") int pageSize) {
        List<PatientDto> p = patientService.getByPageination(pageNumber, pageSize);
        return ResponseEntity.ok(p);
    }
}
