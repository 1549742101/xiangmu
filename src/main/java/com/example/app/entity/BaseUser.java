package com.example.app.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/6
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 */
@Data
public class BaseUser {
    private int id;
    @Length(min = 6,max = 16,message = "账号名必须在6-16位之间")
    @hasUserByUserName
    private String username;
    @Length(min = 6,max = 18,message = "密码长度必须在6-18之间")
    private String password;
    private String passwords;
    private long keyword;
    private int type;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @Pattern(regexp="^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16([5,6])|(17[0-8])|(18[0-9]))|(19[1,8,9]))\\d{8}$",message = "请输入正确的手机号")
    @hasUserByPhone
    private String phone;
    @registerCode
    private int code;
    @AssertTrue(message = "两次输入密码不一致")
    public boolean isSamePassword(){
        if (password!=null&&password.equals(passwords)){
            return true;
        }
        return false;
    }
}
