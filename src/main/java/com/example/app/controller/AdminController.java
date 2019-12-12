package com.example.app.controller;

import com.example.app.entity.BaseUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/8
 * Time: 0:08
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 * */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping({"login","login.html"})
    public String login(Model model){
        BaseUser user=new BaseUser();
        model.addAttribute("user",user);
        boolean [] error = {false,false,false};
        String[] errorMessage = {"","",""};
        String[] url = {"/MCT/login1","/admin/forget"};
        model.addAttribute("error",error);
        model.addAttribute("uri",url);
        model.addAttribute("msg",errorMessage);
        return "login";
    }

}

