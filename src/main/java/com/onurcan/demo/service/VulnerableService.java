package com.onurcan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class VulnerableService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";
        return !jdbcTemplate.queryForList(sql).isEmpty();
    }
}
