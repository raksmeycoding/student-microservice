package org.microservice.studentcourse.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.microservice.studentcourse.entity.Course;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {
    private String name;
    private String instructorName;

    public Course toEntity() {
        return Course.builder()
                .name(this.name)
                .instructorName(this.instructorName)
                .build();
    }
}
