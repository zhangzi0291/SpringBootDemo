package com.demo.base.security.login.handler;

import com.alibaba.fastjson.JSON;
import com.demo.base.R;
import com.demo.utils.SessionUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/14 14:24
 */
public class WebSecurityLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.getWriter().append(JSON.toJSONString(R.ok("退出成功")));
        response.getWriter().flush();
    }
}
