package com.microservice.studentservice.controller;


import com.microservice.studentservice.dto.StudentResponseDto;
import com.microservice.studentservice.entity.Student;
import com.microservice.studentservice.request.StudentRequest;
import com.microservice.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> postStudent(@RequestBody StudentRequest studentRequest) {
        Student savedStudent = studentService.saveStudent(studentRequest.toEntity());
        return ResponseEntity.status(HttpStatus.OK).body(
                StudentResponseDto.builder()
                        .studentDto(savedStudent.toStudentDto())
                        .courseDto(null)
                        .build()
        );
    }


    @GetMapping("{studentId}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable UUID studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                studentService.getStudentById(studentId)
        );
    }


    @DeleteMapping("{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable UUID studentId) {
//        find student and validate
        studentService.deleteStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        StudentResponseDto.builder()
                                .message("student delete successfully")
                                .build()
                );
    }

    @PutMapping("{studentId}")
    public ResponseEntity<?> updateStudentById(@PathVariable UUID studentId, @RequestBody StudentRequest student) {
//        find student and validate
        studentService.updateById(studentId, student);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        StudentResponseDto.builder()
                                .message("student update successfully")
                                .build()
                );
    }

}
