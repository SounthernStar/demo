package com.example.lihuan.demo.dao;

import com.example.lihuan.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao
{

    @Insert("insert into user values(#{id},#{name},#{address})")
    int insert(User record);

    @Select("select * from user")
    List<User> selectAll();

    int insertSelective(User record);
}