package com.example.app.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int id;
    private int user_id;
    private Date time;
    private int state;
}
