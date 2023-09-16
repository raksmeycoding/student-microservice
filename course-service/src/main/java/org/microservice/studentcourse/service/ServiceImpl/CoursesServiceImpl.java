package org.microservice.studentcourse.service.ServiceImpl;


import lombok.RequiredArgsConstructor;
import org.microservice.studentcourse.Request.CourseRequest;
import org.microservice.studentcourse.entity.Course;
import org.microservice.studentcourse.repository.CoursesRepository;
import org.microservice.studentcourse.service.CoursesService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository repository;

    @Override
    public Course getStudentById(UUID id) {
        return findCourseById(id);
    }


    @Override
    public Course saveCourse(CourseRequest courseRequest) {
        return repository.save(courseRequest.toEntity());
    }

    private Course findCourseById(UUID courseId) {
        return repository.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));
    }
}
