package com.example.app.entity;

import com.example.app.util.MD5;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/2
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 **/
public class MD5Test {


    public static void main(String[] args) {
        MD5 md5 = new MD5();
        md5.setKey(Long.parseLong("1573913421280"));
        System.out.println(md5.getMd5("123456"));
    }
}
