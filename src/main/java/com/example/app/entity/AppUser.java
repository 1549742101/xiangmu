package com.example.app.entity;
import java.util.Date;


import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/9
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 *
 * @author xgl
 */
@Data
public class AppUser extends BaseUser {
    @Range(min = 0,max = 1,message = "请选择性别")
    private int sex;
    @NotNull(message = "请输入正确的学号")
    @hasUserBySno
    private Integer sno;
    @hasCol
    private int col_id;
    private int user_id;
}
