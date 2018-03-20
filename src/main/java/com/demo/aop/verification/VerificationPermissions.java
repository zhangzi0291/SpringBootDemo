package com.demo.aop.verification;

import java.lang.annotation.*;

/**
 * 验证是否可以访问平台
 *
 * @Author zhengxiangnan
 * @Date 2017/11/30 13:41
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VerificationPermissions {

    AccessTarget value() default AccessTarget.APP;

}
