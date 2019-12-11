package com.example.app.service.impl;
import	java.io.FileInputStream;
import java.io.FileInputStream;

import com.example.app.entity.AppUser;
import com.example.app.entity.Img;
import com.example.app.mapper.FileMapper;
import com.example.app.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/6
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 **/
@Service
public class FileServiceImpl implements FileService {
    private static Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Autowired
    private FileMapper fileMapper;
    @Override
    public String upload(MultipartFile file, AppUser appUser,String pre) {
        String fileName = Long.toString(Calendar.getInstance().getTimeInMillis())+appUser.getId()+"."+pre;
        File targetFile = new File(uploadFolder,fileName);
        String originalname = file.getOriginalFilename();
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            log.info(e.getMessage());
            return "null";
        }
        Img img = new Img();
        int user_type = appUser.getClass().getName()=="Admin.class"?0:appUser.getClass().getName()=="User.class"?2:1;
        img.setUser_id(appUser.getId());
        img.setFilename(fileName);
        img.setOriginalname(originalname);
        img.setUser_id(appUser.getId());
        img.setType(user_type);
        return fileMapper.upload(img)>0?fileName:null;
    }

    @Override
    public Img getFile(int id) {
        return fileMapper.getImg(id);
    }
}
