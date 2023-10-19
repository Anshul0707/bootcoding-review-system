package com.bootcoding.review.service;

import com.bootcoding.review.model.Student;
import com.bootcoding.review.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Successfully created student!";
    }
}
