package com.example.app.mapper;

import com.example.app.entity.Colleage;
import com.example.app.util.SMS;
import com.example.app.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    User login(User user);
    @Select("select * from col")
    List<Colleage> All_Colleage();
    int hasUser(User user);
    int hasCol(int col_id);
    int registerCode(SMS sms);
    int getCode(@Param("code") Integer code);
}
