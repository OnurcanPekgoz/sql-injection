package com.onurcan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onurcan.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}