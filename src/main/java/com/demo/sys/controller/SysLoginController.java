package com.demo.sys.controller;

import com.demo.base.R;
import com.demo.sys.entity.SysResource;
import com.demo.sys.service.SysResourceService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/6 9:06
 */
@RestController
@RequestMapping("sys")
public class SysLoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysResourceService resourceService;

    @RequestMapping("/getMenu")
    public R getMenu(String username) {
        return R.ok("menu",resourceService.getMenus(username));
    }
    @RequestMapping("/get")
    public R get(String username) {
        System.out.println(1111111111);
        return R.ok("menu");
    }

    @RequestMapping("/unlogin")
    public R get() {
        return R.error("未登录");
    }

//    @RequestMapping("login")
//    public R login(HttpServletRequest request, String loginname,String password) {
//        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(loginname,password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(usernamePasswordToken);   //完成登录
//            SysUser user=(SysUser) subject.getPrincipal();
//            request.getSession().setAttribute("user", user);
//            return R.ok("user",user);
//        } catch (AuthenticationException e) {
//            logger.error("login error: ",e);
//            return R.error("登陆失败");
//        }
//    }

//    @RequestMapping("/logout")
//    public R logOut(HttpServletRequest request) {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        request.getSession().removeAttribute("user");
//        return R.ok("true");
//    }

}
