package com.example.app.controller;

import com.example.app.entity.AppUser;
import com.example.app.entity.BaseUser;
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
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/8
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 */
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
    public String Register(@Valid @ModelAttribute("user") AppUser user, BindingResult bindingResult, Model model){
        model.addAttribute("cols",userService.allCollege());
        if (bindingResult.hasErrors()){
            return "register";
        }else {
            if (userService.registerAppUser(user)>0){
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
        String regx="^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16([5,6])|(17[0-8])|(18[0-9]))|(19[1,8,9]))\\d{8}$";
        if(Pattern.matches(regx,phone)){
            return "请输入正确的手机号";
        }
        sms=new SMS();
        sms.setPhone(phone);
        if (sms.send()&&userService.registerCode(sms)){
            return true+"";
        }
        log.error(sms.toString());
        return "手机号错误或服务器异常，请稍后重试";
    }

    @RequestMapping(value = {"login1"},method = RequestMethod.POST)
    public String login(BaseUser user, Model model){
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
        model.addAttribute("msg",errorMessage);
        return "login";
    }

}
