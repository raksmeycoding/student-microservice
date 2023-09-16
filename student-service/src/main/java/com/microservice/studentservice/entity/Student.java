package com.microservice.studentservice.entity;


import com.microservice.studentservice.constants.Gender;
import com.microservice.studentservice.dto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "student")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String firstname;
    private String lastname;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private UUID courseId;


    public StudentDto toStudentDto() {
        return StudentDto.builder()
                .id(this.id)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .gender(this.gender)
                .email(this.email)
                .courseId(this.courseId)
                .build();
    }





}
