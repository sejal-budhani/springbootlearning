package com.example.spring_security.controller;

import com.example.spring_security.dto.*;
import com.example.spring_security.entity.type.BloodGroup;
import com.example.spring_security.service.AppointmentService;
import com.example.spring_security.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    public PatientController(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
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

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile() {
        Long patientId = 4L;
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }
}
