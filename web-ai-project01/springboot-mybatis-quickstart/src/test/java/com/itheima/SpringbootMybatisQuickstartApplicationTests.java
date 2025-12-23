package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // SpringBoot单元测试的注解-当前测试类中的测试方法运行时，会启动springboot项目-IOC容器
class SpringbootMybatisQuickstartApplicationTests {

	// 注入userMapper
	@Autowired
	private UserMapper userMapper;

	// 即可得到UserMapper在程序运行时通过mytabis自动生成的UserMapper接口的代理对象（bean）
	@Test
	public void testFindAll() {
		// 调用userMapper的findAll方法，查询所有用户信息
		List<User> userList = userMapper.findAll();
		userList.forEach(System.out::println);
	}

}
