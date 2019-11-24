package com.example.app.entity;
import java.util.Date;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 **/
//id;username;password;sex;sno;phone;col;keyword;regtime;endtime;
@Data
public class User {
    private Integer id;//id号
    @Length(min = 5,max = 20,message = "账号名必须在5-18位之间")
    @hasUserByUserName
    private String username;//姓名
    @Length(min = 6,max = 20,message = "密码长度必须在6-20之间")
    private String password;//密码
    private String passwords;//密码
    @Range(min = 0,max = 1,message = "请选择性别")
    private int sex;//性别
    @NotNull(message = "请输入正确的学号")
    @hasUserBySno
    private Integer sno;//学号
    @Pattern(regexp="^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16([5,6])|(17[0-8])|(18[0-9]))|(19[1,8,9]))\\d{8}$",message = "请输入正确的手机号")
    @hasUserByPhone
    private String phone;//电话号
    @hasCol
    private int col_id;//学院
    private Long keyword;//时间戳
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regtime;//注册时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;//最后一次登录时间
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
