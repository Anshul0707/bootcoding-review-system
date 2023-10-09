package com.bootcoding.review.repository;

import com.bootcoding.review.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public UserRepository(DataSource dataSource,
                          JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user){
        try{
            String query = "INSERT into review_user "
                    + " values ('" + user.getUsername() + "'," +
                    "'" + user.getEmailId() + "'," +
                    user.getPhone()+")";
            jdbcTemplate.update(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
