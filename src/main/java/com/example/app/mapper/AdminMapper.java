package com.example.app.mapper;

import com.example.app.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 2:53
 * To change this template use File | Settings | File Templates.
 **/
@Mapper
public interface AdminMapper {
    public Admin login(Admin admin);
}
