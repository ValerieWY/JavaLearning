package com.itheima.Controller;

import com.itheima.Service.UserService;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 用户信息 Controller
@RestController     // @ResponseBody->作用：将controller返回值直接作为响应体的数据直接响应；返回值是对象/集合->json->响应
public class UserController {
   /* @RequestMapping("/list")
    // 返回值！！！ 这里不是 String
    public List<User> list() {
        // 加载并读取user.txt文件，获取用户数据
        // hutool 工具类
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//        System.out.println( lines);
        // 解析用户信息，封装为User对象
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            // parse 将字符串解析为对象
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();

        //[User{id=1, username='daqiao', password='1234567890', name='大乔', age=22, updateTime=2024-07-15T15:05:45}, User{id=2, username='xiaoqiao', password='1234567890', name='小乔', age=18, updateTime=2024-07-15T15:12:09}, User{id=3, username='diaochan', password='1234567890', name='貂蝉', age=21, updateTime=2024-07-15T15:07:16}, User{id=4, username='lvbu', password='1234567890', name='吕布', age=28, updateTime=2024-07-16T10:05:15}, User{id=5, username='zhaoyun', password='1234567890', name='赵云', age=27, updateTime=2024-07-16T11:03:28}, User{id=6, username='zhangfei', password='1234567890', name='张飞', age=31, updateTime=2024-07-16T11:03:28}, User{id=7, username='guanyu', password='1234567890', name='关羽', age=34, updateTime=2024-07-16T12:05:12},
        // User{id=8, username='liubei', password='1234567890', name='刘备', age=37, updateTime=2024-07-16T15:03:28}]

        // 返回数据（json）
        return userList;
    }*/

    // 从Service中获取数据
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public List<User> list() {
        // 调用service获取数据
        List<User> userList = userService.findAll();

        return userList;
    }
}
