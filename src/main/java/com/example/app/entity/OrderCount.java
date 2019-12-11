package com.example.app.entity;

import lombok.Data;
/**
 * Created by IntelliJ IDEA.
 * User: 王霖
 * Date: 2019/12/6
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class OrderCount {
    private int dish_id;
    private int order_id;
    private int count;
    private Double count_money;
}
