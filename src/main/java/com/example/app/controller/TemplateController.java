package com.example.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/18
 * Time: 8:55
 * To change this template use File | Settings | File Templates.
 **/
public class TemplateController {
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping({"login"})
    public String login(){
        return "login";
    }
    @RequestMapping({"register"})
    public String register(){
        return "register";
    }
}
