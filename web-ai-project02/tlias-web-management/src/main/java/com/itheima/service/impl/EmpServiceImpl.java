package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

/*    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 查询总记录数
        Long total = empMapper.count() ;

        // 查询结果列表
//        List<Emp> rows = empMapper.list(page, pageSize); // 第一个参数是起始索引，而不是页码
        // 将页码转换为起始索引，才能传递给mapper.list()
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        // 返回结果PageResult
        return new PageResult<Emp>(total, rows);
    }*/

//    pageHelper
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1、设置起始索引和每页记录数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2、执行查询
        List<Emp> empList = empMapper.list(empQueryParam);

        // 3、封装PageResult返回给用户，但该方法需要两个参数，start和rows
        Page<Emp> p = (Page<Emp>) empList;    // PageHelper分页查询结果对象Page
        // 为什么可以强转：Page<E> extends ArrayList<E>，ArrayList<E> implements List<E>

        return new PageResult<Emp>(p.getTotal(), p.getResult());
        // long List<E> ，刚好符合PageResult需要的类型 Long 和 List<T>
    }

}
