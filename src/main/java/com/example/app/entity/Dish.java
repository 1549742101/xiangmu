package com.example.app.entity;

import lombok.Data;

@Data
public class Dish {
    private int id;
    private String name;
    private Double price;
    private Double discount;
    private String img;
    private int shop_id;
}
