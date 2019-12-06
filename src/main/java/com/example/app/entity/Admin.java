package com.example.app.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Admin {
    private int id;
    private String username;
    private String password;
    private String keyword;
    private Date regtime;
    private Date endtime;
}
