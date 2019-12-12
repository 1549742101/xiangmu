package com.example.app.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 王霖
 * Date: 2019/12/6
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class Order {
    private int id;//订单id
    private int user_id;//用户id
    private Date time;//订单时间
    private int state;//订单状态
    private List<OrderCount> order;//详单
}
