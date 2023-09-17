package org.microservice.studentcourse.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CourseResponseDto {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private CourseDto courseDto;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Integer status;


        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String message;
    }
}
