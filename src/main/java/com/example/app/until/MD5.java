package com.example.app.until;

import lombok.Data;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/10
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 **/
@Setter
public class MD5 {
    private long key;
    public boolean loginByPass(String text,String md5){
        String md5Text = getMd5(text);
        if(md5Text.equalsIgnoreCase(md5))
        {
            return true;
        }
        return false;
    }
    public String getMd5(String text){
        String encodeStr= DigestUtils.md5Hex(text + key);;
        return encodeStr;
    }
}
