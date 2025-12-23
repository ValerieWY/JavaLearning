package com.itheima;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {
    @Test
    public void testUpdate() throws Exception {

        // 1、注册驱动（告诉程序使用的是哪一套实现）
        // 两下shift搜driver
        Class.forName("com.mysql.cj.jdbc.Driver"); // 将指定的类加载到内存中

        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "edmdzreddragon44";
        // 2、获取数据库链接
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3、获取SQL语句执行对象
        Statement statement = connection.createStatement();

        // 4、执行SQL语句
        int i = statement.executeUpdate("update user set age=26 where id=1"); // DML
        System.out.println(i);  // sql语句影响的行数

        // 5、释放资源
        statement.close();
        connection.close();

    }

    @Test
    public void testSelect() throws Exception {
        // 1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2、获取数据库链接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "edmdzreddragon44";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3、获取SQL语句执行对象
        Statement statement = connection.createStatement();

        // 4、执行SQL语句
        String sql = "select * from user where id=1";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String Username = resultSet.getString("username");
            String Password = resultSet.getString("password");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id);
            System.out.println(Username);
            System.out.println(Password);
            System.out.println(name);
            System.out.println(age);
        }

        // 5、释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
