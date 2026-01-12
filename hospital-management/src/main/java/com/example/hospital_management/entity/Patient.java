package com.example.hospital_management.entity;

import com.example.hospital_management.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "patient_insurance_id") // If we don't add this, the default foreign key name would be concatenation of insurance + PK of insurance table i.e insurance_id
//    This is the owning side, as we are adding the foreign key to insurance in Patient table, whereas Insurance table would be Inverse side
//    This is because, the insurance cannot exist without a patient and there can be only one insurance for a patient
//    To avoid confusion to hibernate, we just add mappedby property in insurance table, but its not actually foreign key connected from insurance side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointments;


}
