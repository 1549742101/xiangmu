package com.example.app.entity;

import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/23
 * Time: 2:13
 * To change this template use File | Settings | File Templates.
 **/
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = hasUserByUserNames.class)
@interface hasUserByUserName{
    String message() default "该用户名已经被注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = hasUserByPhones.class)
@interface hasUserByPhone{
    String message() default "该手机号已经被注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = hasUserBySnos.class)
@interface hasUserBySno{
    String message() default "该学号或工号已经被注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = hasCols.class)
@interface hasCol{
    String message() default "请选择你的学院";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = registerCodes.class)
@interface registerCode{
    String message() default "验证码错误";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
/*@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotHasUsers.class)
@interface NotHasUser{
    String message() default "该用户尚未注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}*/


class hasUserByUserNames implements ConstraintValidator<hasUserByUserName,String> {
    @Autowired
    private UserService userService;
    User user = new User();
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        user.setUsername(s);
        return !userService.hasUser(user);
    }
}
class hasUserBySnos implements ConstraintValidator<hasUserBySno,Integer> {
    @Autowired
    private UserService userService;
    User user = new User();
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        user.setSno(s);
        return !userService.hasUser(user);
    }
}
class hasUserByPhones implements ConstraintValidator<hasUserByPhone,String> {
    @Autowired
    private UserService userService;
    User user = new User();
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        user.setPhone(s);
        return !userService.hasUser(user);
    }
}
class hasCols implements ConstraintValidator<hasCol,Integer> {
    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.hasCol(s);
    }
}
class registerCodes implements ConstraintValidator<registerCode,Integer> {
    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.getCode(s);
    }
}
/*
class NotHasUsers implements ConstraintValidator<NotHasUser,String> {
    @Autowired
    private UserService userService;
    User user=new User();
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        user.setUsername(s);
        try {
            user.setSno(Integer.parseInt(s));
        }catch (NumberFormatException e){

        }
        user.setPhone(s);
        return userService.hasUser(user);
    }
}
*/
