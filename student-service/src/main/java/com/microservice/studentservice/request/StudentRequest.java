package com.microservice.studentservice.request;

import com.microservice.studentservice.constants.Gender;
import com.microservice.studentservice.entity.Student;
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
public class StudentRequest {



    private String firstname;
    private String lastname;

    private String email;



    @Enumerated(EnumType.STRING)
    private Gender gender;

    private UUID courseId;

    public Student toEntity() {
        return Student.builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .gender(this.gender)
                .courseId(this.courseId)
                .build();
    }
}
