package com.example.app.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/24
 * Time: 1:33
 * To change this template use File | Settings | File Templates.
 **/
@Data
@NotLogin
public class LoginUser {
    @NotHasUser
    private String username;
    private String password;
}
