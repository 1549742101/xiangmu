package com.example.app.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/6
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class Img {
    private int id;
    private String filename;
    private String originalname;
    private int user_id;
    private int type;
}

