package com.example.app.control;

import com.example.app.entity.SMS;
import com.example.app.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private SMS sms = new SMS();
    @RequestMapping("reg")
    @ResponseBody
    public String Register(String username,String password1,String password2,String sno
    ,String code,String phone,String college){
        System.out.println(sms.getCode().getKey()+";"+code);
        System.out.println(Integer.parseInt(code)==sms.getCode().getKey());
        try {
            if (Integer.parseInt(sno)<150000000||Integer.parseInt(sno)>200000000){
                return "f1";
            }
        }catch (Exception e){
            return "f1";
        }
        if (username.length()<6||username.length()>20){
            return "f2";
        }
        Pattern Password_Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(.{6,20})$");
        Matcher matcher = Password_Pattern.matcher(password1);
        if (!matcher.find()){
            return "f3";
        }
        if (!password1.equals(password2)){
            return "f4";
        }
        if (!(college.equals("DA")||college.equals("IT")||college.equals("NY")||college.equals("CP")||college.equals("CP")))
        {
            return "f5";
        }
        if (!phone.equals(sms.getPhone())){
            return "f6";
        }
        if (!(Integer.parseInt(code)==sms.getCode().getKey())){
            return "f7";
        }
        return "f0";
    }
    @RequestMapping({"register"})
    public String register(){
        return "register.html";
    }

    @RequestMapping("code")
    @ResponseBody
    public String code(String phone){
        sms=new SMS();
        sms.setPhone(phone);
        System.out.println(sms.getCode().getKey());
        return true+"";
    }
}
