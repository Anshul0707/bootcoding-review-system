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

    public String createMultipleCourses(List<Course> courseList) {
        courseRepository.saveMultiple(courseList);
        return "Successfully created multiple courses!";
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    public int deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }

    public int updateCourseById(Course course, Long courseId) {
        return courseRepository.updateCourseById(course, courseId);
    }
}
