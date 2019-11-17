package com.example.app.service.impl;

import com.example.app.entity.MD5;
import com.example.app.entity.User;
import com.example.app.mapper.UserMapper;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 0:37
 * To change this template use File | Settings | File Templates.
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int registerUser(User user) {
        return 0;
    }

    @Override
    public User login(String username, String password) {
        User user;
        user=userMapper.login(username);
        if (user==null){
            return null;
        }
        MD5 md5 = new MD5();
        if (md5.loginByPass(password,user.getKeyword(),user.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public User login1(int sno, String password) {
        return null;
    }

}
