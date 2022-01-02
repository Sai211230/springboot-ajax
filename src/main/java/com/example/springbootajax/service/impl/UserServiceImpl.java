package com.example.springbootajax.service.impl;

import com.example.springbootajax.dao.UserDao;
import com.example.springbootajax.pojo.Grade;
import com.example.springbootajax.service.UserService;
import com.example.springbootajax.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<Grade> findAllGrade() {
        return userDao.findAllGrade();
    }


    @Override
    public Grade findGradeById(Integer id) {
        return userDao.findGradeById(id);
    }

    @Override
    public void deleteGradeById(Integer id) {
        userDao.deleteGradeById(id);
    }

    @Override
    public void saveGrade(Grade grade) {
        userDao.saveGrade(grade);
    }

    @Override
    public User findByUserName(User user) {
        return userDao.findByUserName(user);
    }

    @Override
    public void updateGrade(Grade grade) {
        userDao.updateGrade(grade);
    }

    @Override
    public List<Grade> findGradeByStudentName(String student_name) {
        return userDao.findGradeByStudentName(student_name);
    }
}
