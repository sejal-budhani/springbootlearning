package com.example.hospital_management.service;

import org.modelmapper.ModelMapper;
import com.example.hospital_management.dto.PatientDto;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientService(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    public PatientDto getById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient with id does not exist"));
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        return patientDto;
    }
}
