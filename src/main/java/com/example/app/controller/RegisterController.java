package com.example.app.controller;

import com.example.app.entity.MD5;
import com.example.app.entity.SMS;
import com.example.app.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    private SMS sms = new SMS();

    /**
     * 注册
     * @param username
     * @param password1
     * @param password2
     * @param sno
     * @param code
     * @param phone
     * @param college
     * @return
     */
    @RequestMapping("reg")
    @ResponseBody
    public String Register(String username,String password1,String password2,String sno,int sex
    ,String code,String phone,String college){
        System.out.println(sms.getCode().getKey()+";"+code);
        System.out.println(Integer.parseInt(code)==sms.getCode().getKey());
        try {
            if (Integer.parseInt(sno)<150000000||Integer.parseInt(sno)>200000000){
                return "f1";
            }
        }catch (NumberFormatException e){

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
        User user = new User();
        MD5 md5 = new MD5();
        Long ti= Calendar.getInstance().getTimeInMillis();
        user.setUsername(username);
        user.setPassword(md5.getMd5(password1,ti.toString()));
        user.setKeyword(ti.toString());
        user.setPhone(phone);
        user.setCol(college);
        user.setSno(Integer.parseInt(sno));
        Date date = new Date();
        String str = "yyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        user.setRegtime(sdf.format(date));
        user.setEndtime(sdf.format(date));
        user.setSex(sex);
        return "f0";
    }


    /**
     * 后台获取验证码
     * @param phone
     * @return
     */
    @RequestMapping("code")
    @ResponseBody
    public String code(String phone){
        sms=new SMS();
        sms.setPhone(phone);
        System.out.println(sms.getCode().getKey());
        return true+"";
    }
}
