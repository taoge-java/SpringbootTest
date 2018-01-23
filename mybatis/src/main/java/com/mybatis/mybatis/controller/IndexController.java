package com.mybatis.mybatis.controller;

import com.mybatis.mybatis.mapper.UserInfoMapper;
import com.mybatis.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping("/")
    public void index(){
        UserInfo userInfo = userInfoMapper.getUserInfo("java");

        System.err.println(userInfo.getName());
    }
}
