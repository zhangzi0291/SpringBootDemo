package com.demo.base.api;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 标记版本
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    /**
     * 版本号
     * @return
     */
    String value();

}
