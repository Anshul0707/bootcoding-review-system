package com.bootcoding.review.mapper;
import com.bootcoding.review.model.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(rs.getLong("id"));
        course.setName(rs.getString("name"));
        return course;
    }
}

