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

    public void saveMultiple(List<Course> courseList) {
        try {
            for (Course course : courseList) {
                String query = "INSERT INTO course(name) VALUES (?)";
                jdbcTemplate.update(query, course.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        try {
            String sql = "SELECT * FROM course";
            return jdbcTemplate.query(sql, new RowMapper<Course>() {
                @Override
                public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Course course = new Course();
                    course.setId(rs.getLong("id"));
                    course.setName(rs.getString("name"));
                    return course;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Course getCourseById(Long courseId) {
        try {
            String sql = "SELECT * FROM course WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{courseId}, new RowMapper<Course>() {
                @Override
                public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Course course = new Course();
                    course.setId(rs.getLong("id"));
                    course.setName(rs.getString("name"));
                    return course;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteCourseById(Long courseId) {
        try {
            String sql = "DELETE FROM course WHERE id=?";
            return jdbcTemplate.update(sql, courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateCourseById(Course course, Long id) {
        try {
            String sql = "UPDATE course SET name=? WHERE id=?";
            return jdbcTemplate.update(sql, course.getName(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
