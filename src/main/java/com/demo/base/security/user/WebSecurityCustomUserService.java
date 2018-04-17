package com.demo.base.security.user;

import com.demo.sys.entity.SysRole;
import com.demo.sys.entity.SysUser;
import com.demo.sys.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/6 10:24
 */
@Service
public class WebSecurityCustomUserService implements UserDetailsService {

    @Resource
    private SysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
        SysUser user = userService.findByName(username);
        if(user == null){
//            throw new UsernameNotFoundException("用户名不存在");
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        if(!CollectionUtils.isEmpty(user.getRoleList())) {
            for (SysRole role : user.getRoleList()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        return new WebSecurityCustomUserDetal(user,authorities);
    }

}
