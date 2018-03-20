package com.demo.aop.verification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2017/12/1 13:22
 */
public class ValidateHandler extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Boolean flag = true;
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        VerificationPermissions vp = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), VerificationPermissions.class);
//        // 如果注解为null, 说明不需要拦截, 直接放过
//        if (vp == null) {
//            return true;
//        }

        return true;
    }


}
