package com.example.app.service.impl;

import com.example.app.entity.*;
import com.example.app.mapper.UserMapper;
import com.example.app.service.UserService;
import com.example.app.until.MD5;
import com.example.app.until.SMS;
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
        return userMapper.register(user);
    }

    /**
     * 账号密码登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        user = userMapper.login(user);
        if (user == null) {
            return null;
        }else{
            MD5 md5 = new MD5();
            md5.setKey(user.getKeyword());
            if (md5.loginByPass(user.getPasswords(),user.getPassword())){
                return user;
            }
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

    @Override
    public boolean registerCode(SMS sms) {
        return userMapper.registerCode(sms)>0;
    }

    @Override
    public boolean getCode(Integer code) {
        return userMapper.getCode(code)>0;
    }

}
