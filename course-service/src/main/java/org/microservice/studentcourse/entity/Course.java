package org.microservice.studentcourse.entity;


import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.microservice.studentcourse.dto.CourseDto;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "course")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String instructorName;


    public CourseDto toDto() {
        return CourseDto.builder()
                .id(this.id)
                .name(this.name)
                .instructorName(this.instructorName)
                .build();
    }

}
