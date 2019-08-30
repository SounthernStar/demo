package com.example.lihuan.demo.service;

import com.example.lihuan.demo.dao.UserDao;
import com.example.lihuan.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Transactional
    public boolean addUser(User record)
    {
        User user = new User();
        user.setId(10);
        userDao.insert(user);
        int i = 1/0;
        userDao.insert(record);
        return true;
    }

    @Override
    public List<User> selectAll()
    {
        return userDao.selectAll();
    }


}
