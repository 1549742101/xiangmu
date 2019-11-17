package com.example.app.control;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import com.example.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class LoginControler {
    @Autowired
    UserService userService;
    @RequestMapping({"login"})
    public String login1(){
        return "login";
    }

    @RequestMapping(value = {"login1"},method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password,String code){
        User user;
        user = userService.login(username,password);
        if (user==null){
            return "";
        }
        return user.getId()+username+user.getCol();
    }
}
