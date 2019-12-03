package com.example.app.controller;


import com.example.app.until.SMS;
import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/")
public class RegisterController {
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    private SMS sms = new SMS();

    /**
     * 注册
     * @param user
     * @return user or error message
     */
    @PostMapping("reg")
    public String Register(@Valid@ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        model.addAttribute("cols",userService.All_Colleage());
        if (bindingResult.hasErrors()){
            return "register";
        }else {
            if (userService.registerUser(user)>0){
                return "index";
            }else {
                return "register";
            }
        }
    }
    /**
     * 后台获取验证码
     * @param phone
     * @return
     */
    @RequestMapping("code")
    @ResponseBody
    public String code(String phone, Model model){
        sms=new SMS();
        sms.setPhone(phone);
        if (sms.send()&&userService.registerCode(sms)){
            return true+"";
        }
        log.error(sms.toString());
        return "手机号错误或服务器异常，请稍后重试";
    }
}
