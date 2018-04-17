package com.demo.base.security.url;

import com.demo.sys.entity.SysResource;
import com.demo.sys.entity.SysRole;
import com.demo.sys.service.SysResourceService;
import com.demo.sys.service.SysRoleService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/6 10:36
 */
@Service
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private SysResourceService resourceService;
    @Resource
    private SysRoleService roleService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if (antPathMatcher.match("/sys/login",requestUrl)||antPathMatcher.match("/sys/unlogin",requestUrl)||antPathMatcher.match("/sys/logout",requestUrl)) {
            return null;
        }
        Set<SysRole> resultSet = new HashSet<>();
        List<SysResource> allResource = resourceService.getAllResource();
        for (SysResource resource : allResource) {
            if (antPathMatcher.match(resource.getResourceUrl(), requestUrl)) {
                List<SysRole> roles = roleService.getRoleByResourceId(resource.getId());
                if(CollectionUtils.isEmpty(roles)){
                    continue;
                }
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    public static void main(String[] args) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean b = antPathMatcher.match("/sys/menu/*","/sys/menu/list");
        System.out.println(b);
    }
}
