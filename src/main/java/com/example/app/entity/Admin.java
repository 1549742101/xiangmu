package com.example.app.entity;

import lombok.Data;

import java.util.Date;
/**
 * Created by IntelliJ IDEA.
 * User: 王霖
 * Date: 2019/12/6
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class Admin {
    private int id;
    private String username;
    private String password;
    private String keyword;
    private Date regtime;
    private Date endtime;
}
