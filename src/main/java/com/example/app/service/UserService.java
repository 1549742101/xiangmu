package com.example.app.service;


import com.example.app.entity.AppUser;
import com.example.app.entity.BaseUser;
import com.example.app.entity.College;
import com.example.app.entity.Order;
import com.example.app.util.SMS;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 0:30
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 * */
public interface UserService {
    /**
     * 功能描述 普通用户注册
     * @author xgl
     * @date 2019/12/11
      * @param appUser
     * @return int
     */
    public int registerAppUser(AppUser appUser);
    /**
     * 功能描述 管理员和商家注册
     * @author xgl
     * @date 2019/12/12
      * @param baseUser
     * @return int
     */
    public int registerBaseUser(BaseUser baseUser);
    /**
     * 功能描述 所有用户登录首页
     * @author xgl
     * @date 2019/12/11
      * @param baseUser
     * @return com.example.app.entity.AppUser
     */
    public BaseUser login(BaseUser baseUser);
    /**
     * 功能描述 所有学院信息
     * @author xgl
     * @date 2019/12/11
      * @param
     * @return java.util.List<com.example.app.entity.Colleage>
     */
    public List<College> allCollege();
    /**
     * 功能描述 判断数据库是否有该用户
     * @author xgl
     * @date 2019/12/12
      * @param user
     * @return boolean
     */
    public boolean hasUser(BaseUser user);
    /**
     * 功能描述 判断数据是否有该学院id
     * @author xgl
     * @date 2019/12/12
      * @param col_id
     * @return boolean
     */
    public boolean hasCol(int col_id);
    /**
     * 功能描述 发送用户注册码
     * @author xgl
     * @date 2019/12/12
      * @param sms
     * @return boolean
     */
    public boolean registerCode(SMS sms);
    /**
     * 功能描述 获取用户注册码
     * @author xgl
     * @date 2019/12/12
      * @param code
     * @return boolean
     */
    public boolean getCode(Integer code);
    /**
     * 功能描述 用户订单
     * @author xgl
     * @date 2019/12/12
      * @param order
     * @return boolean
     */
    public boolean Order(Order order);
}
