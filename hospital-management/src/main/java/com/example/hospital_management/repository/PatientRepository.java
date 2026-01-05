package com.example.hospital_management.repository;

import com.example.hospital_management.dto.BloodGroupResponseEntity;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.entity.type.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate date, String email);

//    these are the jpql queries
//    ?1 is the better way as compared to :birthDate as it will prevent sql injection using the column names of table
    @Query("SELECT p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    @Query("SELECT p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

//    @Query("SELECT p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> countByBloodGroup();
//    This can also be returned through Projection

    @Query("SELECT new com.example.hospital_management.dto.BloodGroupResponseEntity(p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupResponseEntity> countByBloodGroup();

//    To write native queries
    @Query(value = "SELECT * from Patient", nativeQuery = true)
    List<Patient> getAll();

//    Updating a record
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id=:id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT p from Patient p")
    Page<Patient> findAllPatients(Pageable pageable);
}
