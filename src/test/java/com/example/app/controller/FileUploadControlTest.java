package com.example.app.controller;

import com.example.app.entity.BaseUser;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;

class FileUploadControlTest {

    @Test
    void upload() throws IOException {
        FileUploadController file = new FileUploadController();
        BaseUser user = new BaseUser();
        user.setId(123);
        File fi = new File("E:/ideaproject/app/src/main/resources/static/img/LoongLove.png");
        InputStream fileInputStream = new FileInputStream(fi);
        MockMultipartFile mfile = new MockMultipartFile(fi.getName(),fileInputStream);
        System.out.println(mfile.getBytes());
        file.upload(mfile,user);
    }
}