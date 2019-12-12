package com.example.app.mapper;

import com.example.app.entity.*;
import com.example.app.util.SMS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 0:50
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 * */
@Mapper
public interface UserMapper {
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param appUser
     * @return int
     */
    int registerAppUser(AppUser appUser);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param baseUser
     * @return int
     */
    int registerBaseUser(BaseUser baseUser);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param appUser
     * @return com.example.app.entity.BaseUser
     */
    AppUser loginAppUser(AppUser appUser);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param
     * @return java.util.List<com.example.app.entity.College>
     */
    @Select("select * from col")
    List<College> allCollege();
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param user
     * @return int
     */
    int hasUser(BaseUser user);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param col_id
     * @return int
     */
    int hasCol(int col_id);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param sms
     * @return int
     */
    int registerCode(SMS sms);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param code
     * @return int
     */
    int getCode(@Param("code") Integer code);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param order
     * @return int
     */
    int insertOrder(Order order);
    /**
     * 功能描述
     * @author xgl
     * @date 2019/12/12
      * @param order
     * @return int
     */
    int insertOrderCount(Order order);

}
