package com.demo.base.security;

import com.demo.base.security.cors.CorsFilter;
import com.demo.base.security.login.WebSecurityAuthenticationProvider;
import com.demo.base.security.login.handler.WebSecurityAuthenticationFailureHandler;
import com.demo.base.security.login.handler.WebSecurityAuthenticationSuccessHandler;
import com.demo.base.security.login.handler.WebSecurityLogoutSuccessHandler;
import com.demo.base.security.url.UrlAccessDecisionManager;
import com.demo.base.security.url.UrlFilterInvocationSecurityMetadataSource;
import com.demo.base.security.user.WebSecurityCustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.annotation.Resource;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/3/5 10:16
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private WebSecurityCustomUserService webSecurityCustomUserService;
    @Resource
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Resource
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Resource
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
    @Resource
    private WebSecurityAuthenticationProvider provider;
    @Resource
    private WebSecurityCustomUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(webSecurityCustomUserService).passwordEncoder(new ShaPasswordEncoder());
        auth.authenticationProvider(new WebSecurityAuthenticationProvider(userService));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/sys/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated().antMatchers(HttpMethod.OPTIONS).permitAll()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);

                        return o;
                    }
                }).and()
            .exceptionHandling().authenticationEntryPoint(new WebSecurityAuthenticationEntryPoint()).and()
            .formLogin()
                .loginProcessingUrl("/sys/login")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(new WebSecurityAuthenticationSuccessHandler())
                .failureHandler(new WebSecurityAuthenticationFailureHandler()).permitAll().and()
            .logout().logoutUrl("/sys/logout").logoutSuccessHandler(new WebSecurityLogoutSuccessHandler()).and()
            .csrf().disable()
//            .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        ;

        http.addFilterAfter(new CorsFilter(), CsrfFilter.class);
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        return provider;
    }
}