package com.example.spring_security.service;

import com.example.spring_security.dto.AppointmentResponseDto;
import com.example.spring_security.entity.Appointment;
import com.example.spring_security.entity.Doctor;
import com.example.spring_security.entity.Patient;
import com.example.spring_security.repository.AppointmentRepository;
import com.example.spring_security.repository.DoctorRepository;
import com.example.spring_security.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId ) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new EntityNotFoundException("Doctor does not exist with id: " + doctorId));
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient does not exist with id: " + patientId));

        if (appointment.getId() != null) {
            System.out.println("Appointment should not be having an id");
        }
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);


//        Bidirectional consistency
        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentid, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentid).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        return appointment;
    }

    public List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        return doctor.getAppointments()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                .collect(Collectors.toList());
    }
}
