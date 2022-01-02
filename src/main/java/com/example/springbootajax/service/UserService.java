package com.example.springbootajax.service;

import com.example.springbootajax.pojo.Grade;
import com.example.springbootajax.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
    void save(User user);
    void update(User user);
    List<Grade> findGradeByStudentName(String student_name);
    User findByUserName(User user);

    User login(User user);
    List<Grade> findAllGrade();
    Grade findGradeById(Integer id);
    void deleteGradeById(Integer id);
    void saveGrade(Grade grade);
    void updateGrade(Grade grade);
}
