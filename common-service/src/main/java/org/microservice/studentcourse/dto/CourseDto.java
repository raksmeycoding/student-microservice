package org.microservice.studentcourse.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CourseDto {
    private UUID id;
    private String name;
    private String instructorName;
}
