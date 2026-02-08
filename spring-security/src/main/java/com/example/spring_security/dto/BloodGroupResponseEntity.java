package com.example.spring_security.dto;

import com.example.spring_security.entity.type.BloodGroup;
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
