package com.example.springbootajax.controller;


import com.example.springbootajax.pojo.Grade;
import com.example.springbootajax.pojo.User;
import com.example.springbootajax.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users",userService.findAll());
        return modelAndView;
    }
    @GetMapping("/findGradeByStudentName")
    public ModelAndView findGradeByStudentName(String student_name){
        ModelAndView modelAndView = new ModelAndView("temp");
        List<Grade> gradeList = userService.findGradeByStudentName(student_name);
        modelAndView.addObject("gradeList",gradeList);
        return modelAndView;
    }

    @PostMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }

    @PostMapping("deleteById")
    public void deleteById(Integer id){
        userService.deleteById(id);
    }

    @PostMapping("/update")
    public void update(User user){
        userService.update(user);
    }

    @PostMapping("/save")
    public void save(User user){
        userService.save(user);
    }

    @GetMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public User login(User user) {
        return userService.login(user);
    }

    @GetMapping("/toGrade")
    public ModelAndView toGrade(){
        ModelAndView modelAndView = new ModelAndView("grade");
        List<Grade> grades = userService.findAllGrade();
        modelAndView.addObject("grades", grades);
        return modelAndView;
    }
    @PostMapping("/findGradeById")
    public Grade findGradeById(Integer id) {
        return userService.findGradeById(id);
    }

    @PostMapping("deleteGradeById")
    public void deleteGradeById(Integer id){
        userService.deleteGradeById(id);
    }

    @PostMapping("/updateGrade")
    public void updateGrade(Grade grade){
        userService.updateGrade(grade);
    }

    @PostMapping("/saveGrade")
    public void saveGrade(Grade grade){
        userService.saveGrade(grade);
    }


    @GetMapping("/toReg")
    public ModelAndView toReg(){
        ModelAndView modelAndView = new ModelAndView("reg");
        return modelAndView;
    }
    @GetMapping("/findByUserName")
    public User findByUserName(User user){
        return userService.findByUserName(user);
    }

}
