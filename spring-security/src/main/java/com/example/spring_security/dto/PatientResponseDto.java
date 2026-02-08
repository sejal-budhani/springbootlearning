package com.example.spring_security.dto;

import lombok.Data;
import com.example.spring_security.entity.type.BloodGroup;
import java.time.LocalDate;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroup bloodGroup;
}
