package com.example.app.entity;

import lombok.Data;

import java.util.Date;
/**
 * Created by IntelliJ IDEA.
 * Date: 2019/12/6
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 *
 * @author 王霖
 * */
@Data
public class Code {
    private int id;
    private String phone;
    private int code;
    private Date time;
}
