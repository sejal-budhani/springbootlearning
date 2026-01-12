package com.example.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Appointment> appointments;

    @ManyToMany(mappedBy = "doctors", fetch = FetchType.EAGER)
    private Set<Department> departments = new HashSet<>();
}
