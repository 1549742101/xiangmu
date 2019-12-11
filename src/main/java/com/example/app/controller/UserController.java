package com.example.app.controller;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import com.example.app.util.SMS;
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
 * Date: 2019/12/8
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/")
@Controller
public class UserController {
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    private SMS sms = new SMS();

    /**
     * 注册
     * @param user
     * @return user or error message
     */
    @PostMapping("reg")
    public String Register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        model.addAttribute("cols",userService.All_Colleage());
        if (bindingResult.hasErrors()){
            return "register";
        }else {
            if (userService.registerUser(user)>0){
                return new IndexController().index(user,model);
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

    @RequestMapping(value = {"login1"},method = RequestMethod.POST)
    public String login(User user, Model model){
        boolean [] error = {false,false,false};
        String[] errorMessage = {"","",""};
        if (userService.hasUser(user)){
            if (userService.login(user)==null){
                error[1]=true;
                errorMessage[1]="密码错误";
            }else {
                return new IndexController().index(userService.login(user),model);
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
