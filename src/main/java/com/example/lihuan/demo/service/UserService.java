package com.example.lihuan.demo.service;

import com.example.lihuan.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
    //User getUserById(int userId);
    boolean addUser(User user);

    List<User> selectAll();
}
