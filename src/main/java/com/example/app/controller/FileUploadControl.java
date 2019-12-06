package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/6
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/")
public class FileUploadControl {
    //文件类型
    public static String IMG_TYPE_PNG = "PNG";
    public static String IMG_TYPE_JPG = "JPG";
    public static String IMG_TYPE_JPEG = "JPEG";
    public static String IMG_TYPE_DMG = "BMP";
    public static String IMG_TYPE_GIF = "GIF";
    public static String IMG_TYPE_SVG = "SVG";
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        
        return "";
    }
}
