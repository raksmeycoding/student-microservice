package org.microservice.studentcourse.controller;


import lombok.RequiredArgsConstructor;
import org.microservice.studentcourse.Request.CourseRequest;
import org.microservice.studentcourse.dto.CourseDto;
import org.microservice.studentcourse.service.CoursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CoursesService coursesService;

    @PostMapping
    public ResponseEntity<CourseDto.CourseResponseDto> postCourse(@RequestBody CourseRequest courseRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CourseDto.CourseResponseDto.builder()
                        .courseDto(coursesService.saveCourse(courseRequest).toDto())
                        .message("Save course successfully")
                        .status(201)
                        .build()
        );

    }


    @GetMapping("{courseId}")
    public ResponseEntity<CourseDto.CourseResponseDto> getCourseById(@PathVariable UUID courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                CourseDto.CourseResponseDto.builder()
                        .courseDto(coursesService.getStudentById(courseId).toDto())
                        .message("Get course by id successfully")
                        .status(200)
                        .build()
        );
    }





}
