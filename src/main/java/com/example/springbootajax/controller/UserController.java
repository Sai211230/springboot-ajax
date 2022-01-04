package com.example.springbootajax.controller;


import com.example.springbootajax.pojo.Grade;
import com.example.springbootajax.pojo.User;
import com.example.springbootajax.service.impl.UserServiceImpl;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //先获取session，如果session中存在user的话说明用户已登录，如果不存在则跳转至登录页面
    @GetMapping("/findAll")
    public ModelAndView findAll(HttpServletRequest request){
        ModelAndView modelAndView = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("users",userService.findAll());
        }else{
            modelAndView = new ModelAndView("login");
        }
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

    //判断是否有此用户，如果有则把用户信息存入session中
    @PostMapping("/login")
    public Integer login(User user,String inputVcode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String Vcode = (String) session.getAttribute("Vcode");
        if (inputVcode != null&& Vcode.equalsIgnoreCase(inputVcode)){
            User u = userService.login(user);
            if (u != null && u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword())){
                session.setAttribute("user",u);
                return 1;
            }else{
                return 0;
            }
        }else{
            return 2;
        }

    }
    @GetMapping("/createCode")
    public void createCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        SpecCaptcha captcha = new SpecCaptcha(130, 48);
        // 获取验证码的字符串
        String text = captcha.text();
        // 获取验证码的字符数组
        char[] chars = captcha.textChar();
        //将获取的验证码的值存入session中
        HttpSession session = request.getSession();
        session.setAttribute("Vcode",text);
        captcha.out(response.getOutputStream());
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
