package com.example.spring_security.dto;

import com.example.spring_security.entity.type.BloodGroup;
import lombok.Data;

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
