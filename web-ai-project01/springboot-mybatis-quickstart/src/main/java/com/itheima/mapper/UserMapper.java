package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 该接口是MyBatis的持久层接口
@Mapper // 应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动将该实现类对象存入IOC容器 -bean
public interface UserMapper {
//    @Select("select * from user")
    // 辅助配置：识别SQL语句（新IDEA中无需专门注入MySQL），右键SQL，选择上下文操作，注入MYSQL
    public List<User> findAll();
    // 移除含有相同User文件的模块即可


    @Delete("delete from user where id = #{id}")
    public void deleteById(Integer id);

    @Insert("insert into user(username,password,name,age) values(#{username},#{password},#{name},#{age})")
    public void insert(User user);

    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age} where id=#{id}")
    public void update(User user);

    // 多参数查询
    @Select("select * from user where username=#{username} and password=#{password}")
//    public User findByUsernameAndPassword(@Param("username")String username,@Param("password") String password);
    // 官方框架 spring boot frame 可省略 @Param ，写形参名称就可以
    public User findByUsernameAndPassword(String username, String password);
}
