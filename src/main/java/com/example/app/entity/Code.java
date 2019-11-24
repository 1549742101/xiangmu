package com.example.app.entity;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/10
 * Time: 0:53
 * To change this template use File | Settings | File Templates.
 **/

public class Code {
    private int key;

    public Code() {
        this.key = new Random().nextInt(900000)+99999;
    }

    public int getKey() {
        return key;
    }
}
