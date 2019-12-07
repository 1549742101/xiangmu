package com.example.app.service;

import com.example.app.entity.AppUser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/6
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 **/
@Service
public interface FileService {
    public String upload(MultipartFile file, AppUser appUser);
    public String getFile();
}
