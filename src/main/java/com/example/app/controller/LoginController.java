package com.example.app.controller;

import com.example.app.entity.LoginUser;
import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class LoginController {
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"login1"},method = RequestMethod.POST)
    public String login(@Valid LoginUser user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "login";
        }
        User users = new User();
        users.setUsername(user.getUsername());
        try {
            users.setSno(Integer.parseInt(user.getUsername()));
        }catch (NumberFormatException e){

        }
        users.setPhone(user.getUsername());
        users.setPassword(user.getPassword());
        model.addAttribute("users",user);
        model.addAttribute("user",userService.login(users));
        return "index";
    }
}
