package com.example.springbootajax.dao;

import com.example.springbootajax.pojo.Grade;
import com.example.springbootajax.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAll();
    List<Grade> findGradeByStudentName(String student_name);
    User findById(Integer id);
    void deleteById(Integer id);
    void save(User user);
    void update(User user);
    User findByUserName(User user);

    User login(User user);
    List<Grade> findAllGrade();
    Grade findGradeById(Integer id);
    void deleteGradeById(Integer id);
    void saveGrade(Grade grade);
    void updateGrade(Grade grade);
}
