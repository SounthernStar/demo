package com.example.lihuan.demo.controller;

import com.example.lihuan.demo.entity.User;
import com.example.lihuan.demo.service.UserService;
import com.sun.tools.internal.ws.processor.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController
{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "addUser")
    public User addUser()
    {
        User user = new User();
        user.setName("zhangsan");
        user.setId(001);
        user.setAddress("ZheJiang");
        userService.addUser(user);
        return user;
    }

    @RequestMapping("getAll")
    public List<User> getAllUser()
    {
        return userService.selectAll();
    }

    @RequestMapping("test")
    public String test()
    {
        logger.info("4+561313164964974681");
        return "Hello World";
    }

}
