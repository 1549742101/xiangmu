package com.example.app.mapper;

import com.example.app.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 0:50
 * To change this template use File | Settings | File Templates.
 **/
@Mapper
public interface UserMapper {
    int register(User user);
    User login(String username);
    User login1(int sno);
}
