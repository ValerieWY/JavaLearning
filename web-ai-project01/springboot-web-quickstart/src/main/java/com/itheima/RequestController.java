package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    // 获取请求参数 HttpServletRequest对象里面封装了所有的请求信息
    public String request(HttpServletRequest request) {
        // 1、获取请求方式
        String method = request.getMethod();    //  GET
        System.out.println(method);

        // 2、获取请求路径 url
        String url = request.getRequestURL().toString();    // http://localhost:8080/request
        System.out.println(url);

        String uri = request.getRequestURI().toString();    // /request
        System.out.println(uri);

        // 3、获取请求协议
        String protocol = request.getProtocol();
        System.out.println( protocol);  // HTTP/1.1

        // 4、获取请求参数 name,age
        // http://localhost:8080/request?name=cxy&age=23
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + ":" + age);   // cxy:23

        // 5、获取请求头 Accept
        String accept = request.getHeader("Accept");
        System.out.println("Accept:" + accept);
        // Accept:text/html,application/xhtml+xml,application/xml;q=0.9,
        // image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7

        return "OK";
    }
}
