package com.onurcan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SecureService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        return !jdbcTemplate.queryForList(sql, username, password).isEmpty();
    }
}
