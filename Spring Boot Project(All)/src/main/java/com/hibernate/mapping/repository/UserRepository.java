package com.hibernate.mapping.repository;

import com.hibernate.mapping.model.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}