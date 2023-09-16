package com.microservice.studentservice.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.microservice.studentcourse.dto.CourseDto;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentResponseDto {




    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StudentDto studentDto;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CourseDto courseDto;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;
}
