package com.example.hospital_management.dto;

import com.example.hospital_management.entity.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupResponseEntity {
    private BloodGroup bloodGroup;
    private Long count;
}
