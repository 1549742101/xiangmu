package com.example.app.entity;

import lombok.Data;

@Data
public class Order_count {
    private int dish_id;
    private int order_id;
    private int count;
    private Double count_money;
}
