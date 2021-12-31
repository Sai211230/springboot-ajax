package com.example.springbootajax.controller;


import com.example.springbootajax.pojo.User;
import com.example.springbootajax.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users",userService.findAll());
        return modelAndView;
    }

    @PostMapping("/findById")
    public User findById(Integer id) {
        System.out.println(id);
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
}
