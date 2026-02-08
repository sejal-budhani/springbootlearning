package com.example.spring_security.service;

import com.example.spring_security.entity.Insurance;
import com.example.spring_security.entity.Patient;
import com.example.spring_security.repository.InsuranceRepository;
import com.example.spring_security.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); // not mandatory, added only for bidirectional consistency
        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(null);
        return  patient;
    }
}
