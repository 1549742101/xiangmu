package com.example.app.entity;

import com.example.app.until.SMS;
import org.junit.jupiter.api.Test;

class SMSTest {
    @Test
    public void test(){
        SMS sms = new SMS();
        sms.setPhone("17353165259");
        System.out.println(sms.send());
    }
}