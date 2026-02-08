package com.example.spring_security.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private DoctorResponseDto doctor;
//    private PatientResponseDto patient;
}
