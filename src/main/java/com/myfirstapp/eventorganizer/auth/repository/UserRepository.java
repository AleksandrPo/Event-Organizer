package com.myfirstapp.eventorganizer.auth.repository;

import com.myfirstapp.eventorganizer.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}