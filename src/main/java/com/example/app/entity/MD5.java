package com.example.app.entity;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/10
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 **/
public class MD5 {
    public boolean loginByPass(String text,String key,String md5){
        String md5Text = getMd5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            return true;
        }
        return false;
    }
    public String getMd5(String text, String key){
        String encodeStr= DigestUtils.md5Hex(text + key);;
        return encodeStr;
    }

    public static void main(String[] args) {
        Long ti=Calendar.getInstance().getTimeInMillis();
        MD5 md5 = new MD5();
        System.out.println(ti.toString());
        String pwd=md5.getMd5("123456",ti.toString());
        String t1="1573913421280";
        String md="c1bd5fead6ec6987520104d607af8e3d";
        String te="123456";
        System.out.println(md5.loginByPass(te,t1,md));
        System.out.println(pwd);
    }
}
