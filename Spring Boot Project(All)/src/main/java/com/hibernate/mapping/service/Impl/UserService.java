package com.hibernate.mapping.service.Impl;


import com.hibernate.mapping.model.UserDao;
import com.hibernate.mapping.model.UserDto;
import com.hibernate.mapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    public UserDao save(UserDto user) {
        UserDao newUser = new UserDao();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

    public UserDao read(String username)
    {
        return userDao.findByUsername(username);
    }
}
