package com.bootcoding.review.repository;

import com.bootcoding.review.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        try {
            String query = "INSERT into review_user(username, emailid, phone)" + " values ('" + user.getUsername() + "','" + user.getEmailId() + "'," + user.getPhone() + ")";
            jdbcTemplate.update(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public List<User> getAllUsers() {
//        try {
//            String sql = "SELECT * FROM review_user";
////             RowMapper is used to map the ResultSet (result of the query) to User objects.
//            return jdbcTemplate.query(sql, new RowMapper<User>() {
//                @Override
//                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                    User user = new User();
//                    user.setUsername(rs.getString("username"));
//                    user.setEmailId(rs.getString("emailid"));
//                    user.setPhone(rs.getInt("phone"));
//                    return user;
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


    public List<User> getAllUsers() {
        try {
            String sql = "SELECT * FROM review_user";
            return jdbcTemplate.query(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setEmailId(rs.getString("emailid"));
                    user.setPhone(rs.getLong("phone"));
                    return user;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int userId) {
        try {
            String sql = "SELECT * FROM review_user WHERE id =?";
            return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setEmailId(rs.getString("emailid"));
                    user.setPhone(rs.getInt("phone"));
                    return user;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteUserById(int userId) {
        try {
            String sql = "DELETE FROM review_user WHERE ID=?";
            return jdbcTemplate.update(sql, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateUserById(User user, int id) {
        try {
            String sql = "UPDATE review_user SET username=? ,emailid=? ,phone=? WHERE ID=?";
            return jdbcTemplate.update(sql, user.getUsername(), user.getEmailId(), user.getPhone(), id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}