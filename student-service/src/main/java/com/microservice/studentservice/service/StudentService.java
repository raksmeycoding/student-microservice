package com.microservice.studentservice.service;

import com.microservice.studentservice.dto.StudentDto;
import com.microservice.studentservice.entity.Student;
import com.microservice.studentservice.repository.StudentRepository;
import com.microservice.studentservice.request.StudentRequest;

import java.util.Optional;
import java.util.UUID;


public interface StudentService {

    Student saveStudent(Student student);

    Student getStudentById(UUID studentId);

    Student updateById(UUID studentId, StudentRequest studentRequest);

    void deleteStudentById(UUID studentId);

}
