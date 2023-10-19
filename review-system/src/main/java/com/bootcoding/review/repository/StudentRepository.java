package com.bootcoding.review.repository;

import com.bootcoding.review.model.Course;
import com.bootcoding.review.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public StudentRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        try {
            String query = "INSERT into student(name)" + " values (?)";
            jdbcTemplate.update(query, student.getName());

            String selectStudentIdQuery = "SELECT id FROM student WHERE name = ?";
            int studentId = jdbcTemplate.queryForObject(selectStudentIdQuery, int.class, student.getName());

            String query2 = "INSERT INTO course(name,student_id)" + " values (?,?)";
            for(Course course: student.getCourses()){
                jdbcTemplate.update(query2, course.getName(),studentId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
