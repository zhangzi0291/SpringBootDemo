package com.demo.base.security.login;

import com.demo.base.security.user.WebSecurityCustomUserDetal;
import com.demo.base.security.user.WebSecurityCustomUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/6 18:06
 */
@Service
public class WebSecurityAuthenticationProvider implements AuthenticationProvider {

    // 是否开启验证码功能
    private boolean isOpenValidateCode = false;


    private boolean postOnly = false;
    public static final String VALIDATE_CODE = "validateCode";

    @Resource
    private WebSecurityCustomUserService userService;

    public WebSecurityAuthenticationProvider() {
    }

    public WebSecurityAuthenticationProvider(WebSecurityCustomUserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!(authentication instanceof UsernamePasswordAuthenticationToken)) {
            return null;
        }
        String webPassword = (String) authentication.getCredentials();
        String webUsername = (String) authentication.getPrincipal();
        WebSecurityCustomUserDetal detal = (WebSecurityCustomUserDetal)userService.loadUserByUsername(webUsername);
        if(detal == null){
            throw new BadCredentialsException("用户不存在");
        }
        String loginname = detal.getUsername();
        String password = detal.getPassword();
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        password = encoder.encodePassword(password,detal.getSalt());
        if (!webPassword.equals(password)) {
            throw new BadCredentialsException("用户密码错误");
        }
        if(!detal.isEnabled()){
            throw new BadCredentialsException("用户不可用");
        }
        if(!detal.isAccountNonLocked()){
            throw new BadCredentialsException("用户被锁定");
        }
        if(!detal.isAccountNonExpired()){
            throw new BadCredentialsException("用户已经过期");
        }

        return createSuccessAuthentication(detal, authentication, detal.getAuthorities());
    }

    private Authentication createSuccessAuthentication(Object principal,
                                                         Authentication authentication, Collection<? extends GrantedAuthority> authorities) {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                principal, authentication.getCredentials(),
                authorities);
        result.setDetails(authentication.getDetails());

        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
