package com.example.app.entity;

import lombok.Data;

import java.util.Date;
/**
 * Created by IntelliJ IDEA.
 * User: 王霖
 * Date: 2019/12/6
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class Order {
    private int id;
    private int user_id;
    private Date time;
    private int state;
}
