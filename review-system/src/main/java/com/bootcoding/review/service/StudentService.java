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

    public String createMultipleStudents(List<Student> studentList) {
        studentRepository.saveMultiple(studentList);
        return "Successfully created multiple students!";
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public int deleteStudentById(Long studentId) {
        return studentRepository.deleteStudentById(studentId);
    }

    public int updateStudentById(Student student, Long studentId) {
        return studentRepository.updateStudentById(student, studentId);
    }
}
