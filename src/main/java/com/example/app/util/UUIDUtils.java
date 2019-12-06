package com.example.app.util;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/3
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 **/
import java.util.UUID;

public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUUID(Integer len) {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, len);
    }
}
