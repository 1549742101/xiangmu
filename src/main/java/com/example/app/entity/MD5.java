package com.example.app.entity;

import org.apache.commons.codec.digest.DigestUtils;

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
}
