package com.example.app.entity;

import com.github.houbb.valid.api.api.result.IResult;
import com.github.houbb.valid.core.api.fail.Fails;
import com.github.houbb.valid.core.api.validator.DefaultValidator;
import com.github.houbb.valid.core.bs.ValidBs;
import org.junit.jupiter.api.Test;



import static org.junit.Assert.*;
class BaseUserTest {

    @Test
    void test1(){
        AppUser appUser = new AppUser();
        BaseUser baseUser = new BaseUser();
        baseUser.setId(1);
        baseUser.setUsername("123456");
        baseUser.setPassword("123456");
        baseUser.setPasswords("12345");
        IResult iResult = ValidBs.on(baseUser).fail(Fails.failOver()).valid(DefaultValidator.getInstance()).result().print();

    }
}