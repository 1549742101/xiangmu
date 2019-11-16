package com.example.app.entity;


/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 **/
public class User {
    private String id;//id号
    private String username;//姓名
    private String password;//密码
    private String sno;//学号
    private String col;//学院
    private String keyword;//时间戳
    private String regtime;//注册时间
    private String betime;//最后一次登录时间

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getBetime() {
        return betime;
    }

    public void setBetime(String betime) {
        this.betime = betime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setCol(String col) {
        this.col = col;
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

    public String getSno() {
        return sno;
    }

    public String getCol() {
        return col;
    }
}
