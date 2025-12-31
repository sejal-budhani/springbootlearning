package com.example.hospital_management.entity;

import com.example.hospital_management.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_birthdate_and_name", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "index_patient_birthdate", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String name;
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

}
