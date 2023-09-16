package org.microservice.studentcourse.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CourseDto courseDto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
