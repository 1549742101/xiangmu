package com.example.app.service;


import com.example.app.entity.Colleage;
import com.example.app.util.SMS;
import com.example.app.entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 0:30
 * To change this template use File | Settings | File Templates.
 **/
public interface UserService {
    public int registerUser(User user);
    public User login(User user);
    public List<Colleage> All_Colleage();
    public boolean hasUser(User user);
    public boolean hasCol(int col_id);
    public boolean registerCode(SMS sms);
    public boolean getCode(Integer code);
}
