package com.example.app.util;

import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/3
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 **/
public class FileHandleUtil {

    /**
     * 上传单个文件
     *
     * @param inputStream 文件流
     * @param path        文件路径，如：image/
     * @param filename    文件名，如：test.jpg
     * @return 成功：上传后的文件访问路径，失败返回：null
     */
    public static String upload(InputStream inputStream, String path, String filename) {
        //创建文件夹
        createDirIfNotExists(path);
        //存文件
        File uploadFile = new File(path, filename);
        try {
            FileUtils.copyInputStreamToFile(inputStream, uploadFile);
        } catch (IOException e) {

        }
        return uploadFile.getPath();
    }

    /**
     * 创建文件夹路径
     */
    private static void createDirIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 删除文件
     *
     * @param path 文件访问的路径upload开始 如： /upload/image/test.jpg
     * @return true 删除成功； false 删除失败
     */
    public static boolean delete(String path) {
        File file = new File(path);
        return file.exists() == true ? file.delete() : true;
    }

    /**
     * 获取服务部署根路径 http:// + ip + port
     *
     * @param request
     * @return
     */
    public static String getServerIPPort(HttpServletRequest request) {
        //+ ":" + request.getServerPort()
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }
}

