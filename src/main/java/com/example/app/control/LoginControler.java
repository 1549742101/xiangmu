package com.example.app.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class LoginControler {
    @RequestMapping({"login1"})
    public String login(String username,String password,String code){
        System.out.println(username+password+code);
        return "";
    }
    @RequestMapping({"login"})
    public String login1(){
        return "login.html";
    }
}
