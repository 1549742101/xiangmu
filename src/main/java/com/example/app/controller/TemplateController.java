package com.example.app.controller;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/18
 * Time: 8:55
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class TemplateController {
    @Autowired
    private UserService userService;
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @GetMapping({"login","login.html"})
    public String login(Model model){
        User user=new User();
        model.addAttribute("user",user);
        boolean [] error = {false,false,false};
        String[] errorMessage = {"","",""};
        model.addAttribute("error",error);
        model.addAttribute("emsg",errorMessage);
        return "login";
    }
    @GetMapping({"register","reg","register.html"})
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("cols",userService.All_Colleage());
        return "register";
    }
    @GetMapping("/")
    public String All(){
        return "login";
    }
}
