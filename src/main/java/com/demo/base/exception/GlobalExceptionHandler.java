package com.demo.base.exception;

import com.demo.base.R;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2017/12/1 9:20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R noHandlerFoundException(Exception ex) {
        return R.error(404, "找不到页面");
    }

    @ExceptionHandler(value = { BadCredentialsException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R BadCredentialsException(Exception ex) {
        return R.error(404, "未登录");
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R unknownException(Exception ex) {
        logger.error("Exception : ",ex);
        return R.error(500, "服务器错误",ex);
    }

}
