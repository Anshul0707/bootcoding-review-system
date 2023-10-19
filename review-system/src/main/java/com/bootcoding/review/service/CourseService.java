package com.bootcoding.review.service;

import com.bootcoding.review.model.Course;
import com.bootcoding.review.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public String createCourse(Course course) {
        courseRepository.save(course);
        return "Successfully created course!";
    }
}
