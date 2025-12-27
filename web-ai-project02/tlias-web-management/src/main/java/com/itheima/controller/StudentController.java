package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public Result list(StudentQueryParam studentQueryParam) {
        log.info("分页查询, 参数: {}", studentQueryParam);
        PageResult<Student> pageResult = studentService.list(studentQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除, ids: {}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("保存员工, 参数: {}", student);
        studentService.save(student);
        return Result.success();
    }
}
