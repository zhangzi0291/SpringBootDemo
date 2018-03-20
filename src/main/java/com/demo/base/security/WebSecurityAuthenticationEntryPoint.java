package com.demo.base.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.base.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/7 10:50
 */
public class WebSecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if(e!=null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"权限问题");
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
}
