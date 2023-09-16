package com.microservice.studentservice.service.ServiceImpl;


import com.microservice.studentservice.entity.Student;
import com.microservice.studentservice.repository.StudentRepository;
import com.microservice.studentservice.request.StudentRequest;
import com.microservice.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.microservice.studentcourse.dto.CourseDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.webjars.NotFoundException;

import java.util.UUID;


@Service
@Primary
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final WebClient webClient;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public Student getStudentById(UUID studentId) {
        var findStudent = findStudentById(studentId);
        var findCourse = webClient.get()
                .uri("http://localhost:2000/api/v1/course/" + findStudent.getCourseId())
                .retrieve()
                .bodyToMono(CourseDto.class).log()
                .block();
        System.out.println(findCourse);
        return null;
    }


    @Override
    public Student updateById(UUID studentId, StudentRequest studentRequest) {
//        find student fist, before update
        var findStudent = findStudentById(studentId);
        findStudent.setFirstname(studentRequest.getFirstname());
        findStudent.setLastname(studentRequest.getLastname());
        findStudent.setEmail(studentRequest.getEmail());
        findStudent.setCourseId(studentRequest.getCourseId());
        return studentRepository.save(findStudent);
    }


    @Override
    public void deleteStudentById(UUID studentId) {
//        validate student exist or not
        handeStudentExistOrNot(studentExistById(studentId));
//        implement delete
        studentRepository.deleteById(studentId);
    }


    private Student findStudentById(UUID studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found!"));
    }


    private boolean studentExistById(UUID studentId) {
        return studentRepository.existsById(studentId);
    }


    private void handeStudentExistOrNot(boolean isStudentExistOrNot) {
        if (!isStudentExistOrNot) {
            throw new NotFoundException("Student is not found!");
        }

    }
}
