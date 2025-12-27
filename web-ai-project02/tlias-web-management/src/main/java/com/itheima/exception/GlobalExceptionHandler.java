package com.itheima.exception;


import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 声明全局异常处理器
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 异常捕获处理方法 handleException，用 @ExceptionHandler 声明
    @ExceptionHandler
    public Result handleException(Exception e) {
        // 输出异常信息
        log.error("服务器发生异常：{}", e.getMessage());
        // 返回错误信息
        return Result.error("服务器出错啦，请联系管理员~");
    }


    // 数据库中违反了唯一约束就报异常（姓名、手机号重复等）,Exception的子异常
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错啦~", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }
}
