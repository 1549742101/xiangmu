package com.example.app.service.impl;
import	java.util.Date;

import com.example.app.entity.Colleage;
import com.example.app.entity.MD5;
import com.example.app.entity.User;
import com.example.app.mapper.UserMapper;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

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
        MD5 md5 = new MD5();
        long key = Calendar.getInstance().getTimeInMillis();
        md5.setKey(key);
        user.setPassword(md5.getMd5(user.getPassword()));
        user.setKeyword(key);
        Date date = new Date();
        user.setRegtime(date);
        return userMapper.register(user);
    }

    /**
     * 账号密码登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user;
        user=userMapper.login(username);
        if (user==null){
            return null;
        }
        MD5 md5 = new MD5();
        md5.setKey(user.getKeyword());
        if (md5.loginByPass(password,user.getPassword())){
            return user;
        }
        return null;
    }

    /**
     * 学号密码登录
     * @param sno
     * @param password
     * @return
     */
    @Override
    public User login1(int sno, String password) {
        User user;
        user=userMapper.login1(sno);
        if (user==null){
            return null;
        }
        MD5 md5 = new MD5();
        md5.setKey(user.getKeyword());
        if (md5.loginByPass(password,user.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public List<Colleage> All_Colleage() {
        return userMapper.All_Colleage();
    }

    @Override
    public boolean hasUser(User user) {
        return userMapper.hasUser(user)>0?true:false;
    }

    @Override
    public boolean hasCol(int col_id) {
        return false;
    }

}
