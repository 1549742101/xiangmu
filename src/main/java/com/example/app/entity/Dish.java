package com.example.app.entity;

import lombok.Data;
/**
 * Created by IntelliJ IDEA.
 * User: 王霖
 * Date: 2019/12/6
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class Dish {
    private int id;
    private String name;
    private Double price;
    private Double discount;
    private String img;
    private int shop_id;
}
