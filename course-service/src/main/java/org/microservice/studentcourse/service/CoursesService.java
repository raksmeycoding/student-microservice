package org.microservice.studentcourse.service;

import org.microservice.studentcourse.Request.CourseRequest;
import org.microservice.studentcourse.dto.CourseDto;
import org.microservice.studentcourse.entity.Course;

import java.util.UUID;

public interface CoursesService {
    Course getStudentById(UUID id);


    Course saveCourse(CourseRequest courseRequest);
}
