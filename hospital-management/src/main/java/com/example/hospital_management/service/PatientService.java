package com.example.hospital_management.service;

import com.example.hospital_management.dto.BloodGroupResponseEntity;
import com.example.hospital_management.entity.type.BloodGroup;
import org.modelmapper.ModelMapper;
import com.example.hospital_management.dto.PatientDto;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public PatientDto getByName(String name) {
        Patient patient = patientRepository.findByName(name);
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        return patientDto;
    }

    public List<PatientDto> getByBirthdateorEmail(LocalDate birthdate, String name) {
        List<Patient> patients = patientRepository.findByBirthDateOrEmail(birthdate, name);
        List<PatientDto> patientDto = new ArrayList<>();
        for (Patient p : patients) {
            PatientDto pdto = modelMapper.map(p, PatientDto.class);
            patientDto.add(pdto);
        }
        return patientDto;
    }

    public List<PatientDto> getByBloodGroup(BloodGroup bloodGroup) {
        List<Patient> patients = patientRepository.findByBloodGroup(bloodGroup);
        List<PatientDto> patientDto = new ArrayList<>();
        for (Patient p : patients) {
            PatientDto pdto = modelMapper.map(p, PatientDto.class);
            patientDto.add(pdto);
        }
        return patientDto;
    }

    public List<PatientDto> getByBornAfterDate(LocalDate birthDate) {
        List<Patient> patients = patientRepository.findByBornAfterDate(birthDate);
        List<PatientDto> patientDto = new ArrayList<>();
        for (Patient p : patients) {
            PatientDto pdto = modelMapper.map(p, PatientDto.class);
            patientDto.add(pdto);
        }
        return patientDto;
    }

    public List<BloodGroupResponseEntity> countByBloodGroup() {
        List<BloodGroupResponseEntity> countGroups = patientRepository.countByBloodGroup();
        return countGroups;
    }

    public List<PatientDto> getByPageination(int pageNumber, int pageSize) {
        Page<Patient> patients = patientRepository.findAllPatients(PageRequest.of(pageNumber, pageSize));
        List<PatientDto> patientDto = new ArrayList<>();
        for (Patient p : patients) {
            PatientDto pdto = modelMapper.map(p, PatientDto.class);
            patientDto.add(pdto);
        }
        return patientDto;
    }
}
