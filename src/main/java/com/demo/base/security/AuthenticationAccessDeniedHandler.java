package com.demo.base.security;

import com.alibaba.fastjson.JSON;
import com.demo.base.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/6 17:40
 */
@Service
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.write(JSON.toJSONString(R.error("权限不足，请联系管理员!")));
        out.flush();
        out.close();
    }
}
