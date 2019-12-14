package com.example.app.controller;


import com.example.app.entity.BaseUser;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

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

}
