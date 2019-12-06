package com.example.app.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/3
 * Time: 0:12
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class Shop {
    private int id;
    private String name;
    private String merchant_id;
    private String logo_img;
    private int type;
    private String shop_type_id;
}
