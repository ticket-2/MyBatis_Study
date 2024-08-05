package com.springtest.mapper;

import com.springtest.POJO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//在运行时，会自动生成该接口的实现类对象（代理对象），并将该对象交给IOC容器管理，（成为IOC容器的BEAN）
public interface UserMapper {  //代理对象

        //查询全部的用户信息
        @Select("select * from user")
        public List<User> list();
    }


