package com.example.app.service.impl;

import com.example.app.entity.*;
import com.example.app.mapper.UserMapper;
import com.example.app.service.UserService;
import com.example.app.util.MD5;
import com.example.app.util.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * AppUser: xgl
 * Date: 2019/11/17
 * Time: 0:37
 * To change this template use File | Settings | File Templates.
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param appUser
     * @return int
     */
    @Override
    public int registerAppUser(AppUser appUser) {
        MD5 md5 = new MD5();
        long key = Calendar.getInstance().getTimeInMillis();
        md5.setKey(key);
        appUser.setPassword(md5.getMd5(appUser.getPassword()));
        appUser.setKeyword(key);
        return userMapper.registerBaseUser(appUser)>0&&userMapper.registerAppUser(appUser)>0?1:-1;
    }

    @Override
    public int registerBaseUser(BaseUser baseUser) {
        MD5 md5 = new MD5();
        long key = Calendar.getInstance().getTimeInMillis();
        md5.setKey(key);
        baseUser.setPassword(md5.getMd5(baseUser.getPassword()));
        baseUser.setKeyword(key);
        return userMapper.registerBaseUser(baseUser);
    }
    @Override
    public BaseUser login(BaseUser baseUser) {
        String pass = baseUser.getPassword();
        long key = baseUser.getKeyword();
        MD5 md5 = new MD5();
        md5.setKey(key);
        if(md5.loginByPass(pass,baseUser.getPassword())){
            baseUser.setPassword("");
            return baseUser;
        }else {
            return null;
        }
    }

    @Override
    public List<College> allCollege() {
        return userMapper.allCollege();
    }

    @Override
    public boolean hasUser(BaseUser baseUser) {
        return userMapper.hasUser(baseUser)>0?true:false;
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

    @Override
    public boolean Order(Order order) {

        return false;
    }

}
