package com.example.app.controller;


import com.example.app.entity.BaseUser;
import com.example.app.entity.IndexBanner;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/12
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 * */
@Controller
@RequestMapping("/")
public class IndexController{
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("Reindex")
    public String Reindex(@ModelAttribute("user") BaseUser user, Model model){
        model.addAttribute("user",user);
        return "app/index";
    }
    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("user", new BaseUser());
        return "app/index";
    }
    @RequestMapping("getBanner")
    @ResponseBody
    public List<IndexBanner> banner(){
        return userService.getAllBanner();
    }
}
