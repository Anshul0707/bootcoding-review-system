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

    @PostMapping("/students")
    public String createMultipleStudents(@RequestBody List<Student> students) {
        return studentService.createMultipleStudents(students);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public int deleteStudentById(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/student/{id}")
    public int updateStudentById(@RequestBody Student student, @PathVariable Long id) {
        return studentService.updateStudentById(student, id);
    }

}
