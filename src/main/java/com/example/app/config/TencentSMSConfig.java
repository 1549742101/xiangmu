package com.example.app.config;

import com.example.app.until.TencentSMS;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/10
 * Time: 0:37
 * To change this template use File | Settings | File Templates.
 **/
public class TencentSMSConfig extends TencentSMS{
    final private int appid=1400283326;
    final private String appkey="d9df7fbb4046c4bc6ade919f7ed2d0db";
    final private int templateId=468830;
    final private String smsSign="个人开发学习网";
    public TencentSMSConfig() {
        this.setAppid(appid);
        this.setAppkey(appkey);
        this.setTemplateId(templateId);
        this.setSmsSign(smsSign);
    }
}
