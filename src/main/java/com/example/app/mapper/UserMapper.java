package com.example.app.mapper;

import com.example.app.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/12
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 **/
@Mapper
public interface UserMapper {
    User login(String username, String password);
    int register(User user);
}
