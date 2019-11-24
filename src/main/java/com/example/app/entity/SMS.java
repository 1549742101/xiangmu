package com.example.app.entity;

import com.example.app.config.TencentSMSConfig;
import com.example.app.controller.LoginController;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/10
 * Time: 0:51
 * To change this template use File | Settings | File Templates.
 **/
public class SMS {
    /**
     * 日志文件
     */
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    private String phone;
    private String[] phones;
    private Code code;
    private TencentSMSConfig config;
    public SMS() {
        code=new Code();
        config = new TencentSMSConfig();
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        config.setPhoneNumbers(new String[]{phone});
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
        config.setPhoneNumbers(phones);
    }

    public Code getCode() {
        /*if (!send()){
            code=null;
        }*/
        return code;
    }
    public boolean send(){
        try {
            String[] params = {Integer.toString(code.getKey())};
            SmsMultiSender ssender = new SmsMultiSender(config.getAppid(), config.getAppkey());
            /*SmsSingleSenderResult result = ssender.send(0, "86", config.getPhoneNumbers()[0],
                    "【"+config.getSmsSign()+"】"+params+"为你本次注册的验证码，如果非本人注册，请忽略此验证码", "", "");*/
            SmsMultiSenderResult result  = ssender.sendWithParam("86", config.getPhoneNumbers(),
                    config.getTemplateId(), params, config.getSmsSign(), "", "");
            log.info(result.toString());
            return true;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            log.error(e.getMessage());
        } catch (JSONException e) {
            // JSON 解析错误
            log.error(e.getMessage());
        } catch (IOException e) {
            // 网络 IO 错误
            log.error(e.getMessage());
        }
        return false;
    }

    public String toString(){
        return this.phone+";"+this.phones.toString()+";"+this.getCode().getKey();
    }
}
