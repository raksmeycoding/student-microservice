package com.microservice.studentservice.dto;


import com.microservice.studentservice.constants.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentDto {

    private UUID id;


    private String firstname;
    private String lastname;

    private String email;



    @Enumerated(EnumType.STRING)
    private Gender gender;

    private UUID courseId;
}
