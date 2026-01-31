package com.example.hospital_management;

import com.example.hospital_management.entity.Appointment;
import com.example.hospital_management.entity.Insurance;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.service.AppointmentService;
import com.example.hospital_management.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {
//        An object can also be created this way when there is no Builder annotation added to insurance entity
//        Insurance insurance = new Insurance();
//        insurance.setPolicyNumber("HDFC_1234");
//        insurance.setProvider("HDFC");
//        insurance.setValidUntil(LocalDate.of(2030, 12, 1));

//        After adding builder annotation, we can use this..
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .validUntil(LocalDate.of(2030, 12, 1))
                .provider("HDFC")
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);
        Patient newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }

    @Test
    public void testAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 1, 12, 3, 30, 0))
                .reason("General checkup")
                .build();

        var appointmentCreated = appointmentService.createAppointment(appointment, 1L, 2L);
        System.out.println(appointmentCreated);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(appointmentCreated.getId(), 3L);
        System.out.println(updatedAppointment);

    }
}
