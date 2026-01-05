package com.example.hospital_management.dto;

import com.example.hospital_management.entity.type.BloodGroup;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientDto {

    private String name;
    private String email;
    private String gender;
    private LocalDate birthDate;
    private BloodGroup bloodGroup;
    private LocalDateTime createdAt;
}
