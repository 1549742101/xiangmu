package com.example.app.mapper;

import com.example.app.entity.BaseUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 2:53
 * To change this template use File | Settings | File Templates.
 **/
@Mapper
public interface AdminMapper {
    public BaseUser login(BaseUser admin);
}
