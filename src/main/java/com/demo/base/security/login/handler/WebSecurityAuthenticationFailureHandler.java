package com.demo.base.security.login.handler;

import com.alibaba.fastjson.JSON;
import com.demo.base.R;
import com.demo.utils.SessionUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/7 16:58
 */
public class WebSecurityAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.getWriter().append(JSON.toJSONString(R.error(exception.toString())));
        response.getWriter().flush();
    }
}
