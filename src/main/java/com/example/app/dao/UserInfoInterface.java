package com.example.app.dao;

import com.example.app.entity.User;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/12
 * Time: 9:38
 * To change this template use File | Settings | File Templates.
 **/
public interface UserInfoInterface {
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean loginUser(User user);
}
