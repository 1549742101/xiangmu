package com.example.app.control;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class LoginControler {
    private static Logger log = LoggerFactory.getLogger(LoginControler.class);
    @Autowired
    private UserService userService;
    @RequestMapping({"login"})
    public String login1(){
        return "login";
    }

    @RequestMapping(value = {"login1"},method = RequestMethod.POST)
    public String login(String username, String password, String code, Model model){
        if(username.length()<6||username.length()>20){
            return "login?msg=0003";
        }
        User user;
        int sno=-1;
        user = userService.login(username,password);
        if (user==null&&username.length()==9){
            try {
                sno = Integer.parseInt(username);
            }catch (NumberFormatException e){
                log.error(e.getMessage());
            }
            if (sno==-1){
                return "login?msg=0002";
            }else {
                user = userService.login1(sno,password);
                if (user==null){
                    return "login?msg=0001";
                }
            }
        }
        model.addAttribute("user",user);
        return "index";
    }

    /*public static void main(String[] args) {
        try {
            int uuu=Integer.parseInt("aaa111");
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
