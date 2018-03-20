package com.demo.base.security.login.handler;

import com.alibaba.fastjson.JSON;
import com.demo.base.R;
import com.demo.utils.SessionUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

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
public class WebSecurityAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.getWriter().append(JSON.toJSONString(R.ok("user", SessionUtil.getCurrentUserDetal())));
        response.getWriter().flush();
    }
}
