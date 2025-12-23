package com.itheima;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    // 方式一：HttpServletResponse设置响应数据
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        // 1、设置响应状态码
        response.setStatus(HttpServletResponse.SC_OK);

        // 2、设置响应头
        response.setHeader("name", "itheima");

        // 3、设置响应体
        response.getWriter().write("<h1>hello,response</h1>");

    }

    // 响应状态码和响应头如果没有特殊要求的话，通常不手动设定。
    // 服务器会根据请求处理的逻辑，自动设置响应状态码和响应头。

    // 方式二：使用ResponseEntity设置响应数据 -Spring中提供的数据
    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(200)
                .header("name", "javaweb-ai")
                .body("<h1>hello,response2</h1>");
    }

}
