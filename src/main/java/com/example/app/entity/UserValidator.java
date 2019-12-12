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
 * @author xgl
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserByUserName.class)
@interface hasUserByUserName{
    String message() default "该用户名已经被注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
/**
 * @author xgl
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserByPhone.class)
@interface hasUserByPhone{
    String message() default "该手机号已经被注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
/**
 * @author xgl
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserBySno.class)
@interface hasUserBySno{
    String message() default "该学号或工号已经被注册";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
/**
 * @author xgl
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Cols.class)
@interface hasCol{
    String message() default "请选择你的学院";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
/**
 * @author xgl
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Codes.class)
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


class UserByUserName implements ConstraintValidator<hasUserByUserName,String> {
    @Autowired
    private UserService userService;
    AppUser user = new AppUser();
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        user.setUsername(s);
        return !userService.hasUser(user);
    }
}
class UserBySno implements ConstraintValidator<hasUserBySno,Integer> {
    @Autowired
    private UserService userService;
    AppUser user = new AppUser();
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        user.setSno(s);
        return !userService.hasUser(user);
    }
}
class UserByPhone implements ConstraintValidator<hasUserByPhone,String> {
    @Autowired
    private UserService userService;
    AppUser user = new AppUser();
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        user.setPhone(s);
        return !userService.hasUser(user);
    }
}
class Cols implements ConstraintValidator<hasCol,Integer> {
    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.hasCol(s);
    }
}
class Codes implements ConstraintValidator<registerCode,Integer> {
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
