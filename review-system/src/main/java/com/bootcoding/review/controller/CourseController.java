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
}
