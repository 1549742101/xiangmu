package com.example.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SMSTest {
    @Test
    public void test(){
        SMS sms = new SMS();
        sms.setPhone("17353165259");
        System.out.println(sms.send());
    }
}