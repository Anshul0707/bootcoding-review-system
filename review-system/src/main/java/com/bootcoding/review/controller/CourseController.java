package com.bootcoding.review.controller;

import com.bootcoding.review.model.Course;
import com.bootcoding.review.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public String createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PostMapping("/courses")
    public String createMultipleCourses(@RequestBody List<Course> courses) {
        return courseService.createMultipleCourses(courses);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/course/{id}")
    public int deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }

    @PutMapping("/course/{id}")
    public int updateCourseById(@RequestBody Course course, @PathVariable Long id) {
        return courseService.updateCourseById(course, id);
    }
}
