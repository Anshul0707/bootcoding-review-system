package com.bootcoding.review.repository;

import com.bootcoding.review.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CourseRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public CourseRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Course course) {
        try {
            String query = "INSERT into course(name)" + " values (?)";
            jdbcTemplate.update(query, course.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
