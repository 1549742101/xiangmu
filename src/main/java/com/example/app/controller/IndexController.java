package com.example.app.controller;

import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/12
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class IndexController {
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("index")
    public String index(Model model){
        return "app/index";
    }


}
