package com.example.app.entity;


/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 **/
//id;username;password;sex;sno;phone;col;keyword;regtime;endtime;
public class User {
    private String id;//id号
    private String username;//姓名
    private String password;//密码
    private int sex;//性别
    private int sno;//学号
    private String phone;//电话号
    private String col;//学院
    private String keyword;//时间戳
    private String regtime;//注册时间
    private String endtime;//最后一次登录时间

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSex() {
        return sex;
    }

    public int getSno() {
        return sno;
    }

    public String getPhone() {
        return phone;
    }

    public String getCol() {
        return col;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getRegtime() {
        return regtime;
    }

    public String getEndtime() {
        return endtime;
    }

}
