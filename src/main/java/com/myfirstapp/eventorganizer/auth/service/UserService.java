package com.myfirstapp.eventorganizer.auth.service;

import com.myfirstapp.eventorganizer.auth.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
