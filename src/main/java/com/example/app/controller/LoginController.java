package com.example.app.controller;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String login(User user, Model model){
        boolean [] error = {false,false,false};
        String[] errorMessage = {"","",""};
        if (userService.hasUser(user)){
            if (userService.login(user)==null){
                error[1]=true;
                errorMessage[1]="密码错误";
            }else {
                model.addAttribute("user",userService.login(user));
                return "forward:index";
            }
        }else {
            error[0]=true;
            errorMessage[0]="账号不存在";
        }
        model.addAttribute("error",error);
        model.addAttribute("emsg",errorMessage);
        return "login";
    }
}
