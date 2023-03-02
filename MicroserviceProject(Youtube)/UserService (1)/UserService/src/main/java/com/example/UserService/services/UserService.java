package com.example.UserService.services;

import com.example.UserService.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  User  saveUser(User user);

 List<User> getAllUser();

 User getUser(String userId);

 void deleteUser(String userId);
 User updateUser(User user);
}
