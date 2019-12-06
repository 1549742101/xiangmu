package com.example.app.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Code {
    private int id;
    private String phone;
    private int code;
    private Date time;
}
