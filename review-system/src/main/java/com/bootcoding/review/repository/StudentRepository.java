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

    public void saveMultiple(List<Student> studentList) {
        try {
            for (Student student : studentList) {
                String query = "INSERT INTO student(name) VALUES (?)";
                jdbcTemplate.update(query, student.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        try {
            String sql = "SELECT * FROM student";
            return jdbcTemplate.query(sql, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    // You can add logic to fetch and set courses here if needed
                    return student;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(Long studentId) {
        try {
            String sql = "SELECT * FROM student WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{studentId}, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    // You can add logic to fetch and set courses here if needed
                    return student;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteStudentById(Long studentId) {
        try {
            String sql = "DELETE FROM student WHERE id=?";
            return jdbcTemplate.update(sql, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateStudentById(Student student, Long id) {
        try {
            String sql = "UPDATE student SET name=? WHERE id=?";
            return jdbcTemplate.update(sql, student.getName(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
