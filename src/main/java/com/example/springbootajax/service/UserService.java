package com.example.springbootajax.service;

import com.example.springbootajax.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
    void save(User user);
    void update(User user);
}
