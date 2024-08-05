package com.springtest;

import com.springtest.POJO.Emp;
import com.springtest.POJO.User;
import com.springtest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import com.springtest.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest  //springboot整合单元测试的注解
class SpringbootMybatisApplicationTests {

   /* @Autowired
    private UserMapper userMapper;   //注入userMapper接口

    @Test
    public void testListUser(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }*/
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete()
    {
        int delete = empMapper.delete(17);
        System.out.println(delete);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("ulquir");
        emp.setName("乌尔奥齐拉");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2024, 12, 13));
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
        //System.out.println(emp.getId());
        //empMapper.insert(emp);

    }
    @Test
    public void testSelect()
    {
        Emp emp = empMapper.select(18);
        System.out.println(emp);
    }


    @Test
    public void testList()
    {
        List<Emp> emplist = empMapper.list("张",(short)1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
        System.out.println(emplist);
    }



}
