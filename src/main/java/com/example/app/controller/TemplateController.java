package com.example.app.controller;

import com.example.app.entity.AppUser;
import com.example.app.entity.BaseUser;
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
 *
 * @author xgl
 * */
@Controller
@RequestMapping("/")
public class TemplateController {
    @Autowired
    private UserService userService;
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(TemplateController.class);
    @GetMapping({"login","login.html","login1"})
    public String login(Model model){
        BaseUser user=new BaseUser();
        model.addAttribute("user",user);
        boolean [] error = {false,false,false};
        String[] errorMessage = {"","",""};
        String[] url = {"/login1","/register","forget"};
        model.addAttribute("uri",url);
        model.addAttribute("error",error);
        model.addAttribute("msg",errorMessage);
        return "login";
    }
    @GetMapping({"register","reg","register.html"})
    public String register(Model model){
        AppUser user = new AppUser();
        model.addAttribute("user",user);
        model.addAttribute("cols",userService.allCollege());
        return "register";
    }
    /*@GetMapping("/")
    public String All(Model model){
        return login(model);
    }*/
}
