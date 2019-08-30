package com.example.lihuan.demo.controller;

import com.example.lihuan.demo.entity.User;
import com.example.lihuan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
@CrossOrigin
public class TestBootController
{
    @Resource
    private UserService userService;

    @RequestMapping("getuser")
    public User getUser(@RequestParam   String ss, HttpServletResponse response)
    {
        User user = new User();
        user.setName(ss);
        userService.addUser(user);

        response.setHeader("token","token123");

        return user;
    }
}