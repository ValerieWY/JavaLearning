package com.itheima;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 请求处理类
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello," +  name + "~";
    }

}
