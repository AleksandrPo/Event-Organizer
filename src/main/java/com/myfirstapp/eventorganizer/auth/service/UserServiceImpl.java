package com.myfirstapp.eventorganizer.auth.service;

import com.myfirstapp.eventorganizer.auth.model.User;
import com.myfirstapp.eventorganizer.auth.model.UserStatus;
import com.myfirstapp.eventorganizer.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole_id(1);
        user.setUser_status(UserStatus.ACTIVE.toString());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
