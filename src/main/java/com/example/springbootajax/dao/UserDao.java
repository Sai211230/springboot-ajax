package com.example.springbootajax.dao;

import com.example.springbootajax.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
    void save(User user);
    void update(User user);
}
