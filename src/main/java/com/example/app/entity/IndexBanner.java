package com.example.app.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/11
 */
@Data
public class IndexBanner {
    int id;
    /**
     默认为0，开关0/1
     */
    int type;
    String text;
    Img img;
    Date date;
}
