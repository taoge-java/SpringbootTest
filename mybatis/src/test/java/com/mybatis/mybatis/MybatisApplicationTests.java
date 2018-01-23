package com.mybatis.mybatis;

import com.mybatis.mybatis.mapper.UserInfoMapper;
import com.mybatis.mybatis.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.mybatis.mybatis.mapper")
public class MybatisApplicationTests {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Test
	public void contextLoads() {
		UserInfo userInfo = userInfoMapper.getUserInfo("java");
		System.out.println(userInfo.getName());
	}
}
