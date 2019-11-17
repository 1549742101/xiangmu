package com.example.app.service;

import com.example.app.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 0:30
 * To change this template use File | Settings | File Templates.
 **/
public interface UserService {
    public int registerUser(User user);
    public User login(String username,String password);
    public User login1(int sno,String password);
}
