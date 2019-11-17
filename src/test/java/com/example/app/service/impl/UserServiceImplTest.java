package com.example.app.service.impl;

import com.example.app.entity.User;
import com.example.app.mapper.UserMapper;
import com.example.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserMapper userMapper;
    @Test
    void login() {
        User user = userMapper.login("001");
        System.out.println(user.getPhone());
    }
}