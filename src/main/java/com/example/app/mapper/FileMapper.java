package com.example.app.mapper;

import com.example.app.entity.Img;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/8
 * Time: 1:26
 * To change this template use File | Settings | File Templates.
 **/
@Mapper
public interface FileMapper {
    int upload(Img img);
    Img getImg();
}
