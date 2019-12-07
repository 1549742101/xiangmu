package com.example.app.controller;

import com.example.app.entity.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/8
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/MCT")
public class MerchantController {
    @GetMapping({"login","login.html"})
    public String login(Model model){
        AppUser user=new AppUser();
        model.addAttribute("user",user);
        boolean [] error = {false,false,false};
        String[] errorMessage = {"","",""};
        String[] url = {"/MCT/login1","/MCT/register","/MCT/forget"};
        model.addAttribute("uri",url);
        model.addAttribute("error",error);
        model.addAttribute("emsg",errorMessage);
        return "login";
    }
}
