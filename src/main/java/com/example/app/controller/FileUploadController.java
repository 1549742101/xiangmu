package com.example.app.controller;

import com.example.app.entity.Admin;
import com.example.app.entity.AppUser;
import com.example.app.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/6
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/")
public class FileUploadController {
    private static Logger log = LoggerFactory.getLogger(FileUploadController.class);
    //文件类型
    private String[] fileType = {"PNG","JPG","JPEG","BMP","GIF","SVG"};

    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, AppUser appUser) {
        if (file.isEmpty()){
            return "请选择文件";
        }
        String filename = file.getOriginalFilename();
        Admin user = new Admin();
        user.setId(123);
        appUser =user;
        for (String pre:fileType){
            if (filename.toUpperCase().endsWith(pre)) {
                try {
                    return fileService.upload(file,appUser,pre.toLowerCase());
                } catch (IOException e) {
                    log.info(e.getMessage());
                    return "文件上传失败";
                }
            }
        }
        return "不符合文件规范";
    }

}
