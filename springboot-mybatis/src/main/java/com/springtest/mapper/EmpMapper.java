package com.springtest.mapper;


import com.springtest.POJO.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Mapper
public interface EmpMapper {

    //根据ID删除
    @Delete("delete from emp where id = #{id}")   //#{...}预编译 可防止sql注入
    public int delete(Integer id);


    //新增
    //OPtions用于获取主键值，使主键值可以通过打印出来
    @Options(keyProperty = "id", useGeneratedKeys = true)//useGeneratedKeys表示需要获取主键值，keyProperty表示主键是id
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    public void insert(Emp emp);


    //更新
    @Update("UPDATE emp set username=#{username}, name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},create_time=#{createTime},update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    /*//查询
    //如果mysql属性名与字段名不一致，则mybatis不会自动封装，返回值为0或者null
    @Select("select * from emp where id = #{id}")
    public Emp select(int id);
*/
    /*//方法一——  给字段起别名，保持与属性名一样
    @Select("select id, username, password, name, gender, image, job, entrydate," +
            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
    public Emp select(int id);
*/
    //方法二：@Results手动映射 @Results({@Result(column = "被封装的value", property = "封装成value")})
    /*@Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property =  "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from emp where id = #{id}")
    public Emp select(int id);*/
    //方案三： 开启mybatis的驼峰命名的自动映射开关
    @Select("select * from emp where id = #{id}")
    public Emp select(int id);


    //条件查询
  /*  @Select("select * from emp where name like '%${name}%' and gender=#{gender} and " +
            "entrydate between #{begin} and #{end} order by update_time desc")
    //这个查询的数据无法封装为对象,因为其中入职日期是范围-->建议直接把参数放入方法形参
    //@Param注解的作用是给参数命名，参数命名后就能根据名字得到参数值，正确的将参数传入sql语句中
    public List<Emp> list(@Param("name") String name, @Param("gender")Short gender,@Param("begin") LocalDate begin,@Param("end")LocalDate end);*/
    //'%${name}%'可能引发sql注入

    //利用concat可预防sql注入
    /*@Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
            "entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(@Param("name") String name, @Param("gender")Short gender,@Param("begin") LocalDate begin,@Param("end")LocalDate end);
*/
    //利用xml映射
    public List<Emp> list(@Param("name") String name, @Param("gender")Short gender,@Param("begin") LocalDate begin,@Param("end")LocalDate end);

}
