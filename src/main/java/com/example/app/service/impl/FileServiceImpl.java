package com.example.app.service.impl;

import com.example.app.entity.AppUser;
import com.example.app.entity.Img;
import com.example.app.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Override
    public String upload(MultipartFile file, AppUser appUser) {
        String fileName = Long.toString(Calendar.getInstance().getTimeInMillis())+appUser.getId();
        String originalname = file.getOriginalFilename();
        Img img = new Img();
        System.out.println(appUser.getClass().getName());
        img.setUser_id(appUser.getId());
        img.setFilename(fileName);
        img.setOriginalname(originalname);
        System.out.println(img.toString());
        return null;
    }

    @Override
    public String getFile() {
        return null;
    }
}
