package com.example.hospital_management;

import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import com.example.hospital_management.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
//        List<Patient> patientList = patientRepository.findAll();
//        This findall will give us n+1 problem as their will be one query to find all patients
//        and there will be n more queries if there were n patients found to find their appointments
//        This will have multiple queries and will have load on database and not optimized
//        To solve this we will call custom query added with join to have the appointments also to be called in the same 1 query

        List<Patient> patientList = patientRepository.findAllPatientWithAppointments();
        System.out.println(patientList);
    }
}
