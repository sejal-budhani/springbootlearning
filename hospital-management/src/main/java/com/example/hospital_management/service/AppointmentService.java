package com.example.hospital_management.service;

import com.example.hospital_management.entity.Appointment;
import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.AppointmentRepository;
import com.example.hospital_management.repository.DoctorRepository;
import com.example.hospital_management.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

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
}
