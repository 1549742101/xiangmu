package com.example.app.entity;

import lombok.Data;

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
    int img_id;
    int type;
    String uri;
    String text;
}
