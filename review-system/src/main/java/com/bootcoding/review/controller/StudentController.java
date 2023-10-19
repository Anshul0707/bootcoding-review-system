package com.bootcoding.review.controller;

import com.bootcoding.review.model.Student;
import com.bootcoding.review.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

}
