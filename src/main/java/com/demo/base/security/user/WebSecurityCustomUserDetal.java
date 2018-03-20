package com.demo.base.security.user;

import com.demo.sys.entity.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/7 9:37
 */
public class WebSecurityCustomUserDetal extends SysUser implements UserDetails {

    private Collection<GrantedAuthority> authorities;

    public WebSecurityCustomUserDetal() {

    }

    public WebSecurityCustomUserDetal(SysUser user,Collection<GrantedAuthority> authorities) {
        BeanUtils.copyProperties(user,this);
        this.authorities = authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.getExpiredTime()==null?true:super.getExpiredTime().compareTo(new Date()) >= 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getStatus()==null?true:!"2".equals(super.getStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.getStatus()==null?true:"1".equals(super.getStatus());
    }
}
