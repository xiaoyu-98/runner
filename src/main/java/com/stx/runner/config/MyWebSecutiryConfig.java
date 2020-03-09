package com.stx.runner.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stx.runner.entity.RespBean;
import com.stx.runner.entity.User;
import com.stx.runner.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 类描述:
 *
 * @author xiaoyu
 * on 2020/3/8
 */
@Configuration
public class MyWebSecutiryConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userService;

    //密码加密
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//开启HttpSecurity的配置
                .antMatchers("/user/register")
                //表示该接口不需要通过认证就可以访问
                .permitAll()
                .anyRequest()
                .authenticated()//除了前面定义的url外，用户访问其他的url都必须登录后访问
                .and()
                .formLogin() //表单配置
                .usernameParameter("username") //登录参数中用户名和密码名规定
                .passwordParameter("password")
                .loginProcessingUrl("/login") //登录接口
//                .loginPage("/login") //登录页面
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        User user = (User) authentication.getPrincipal();
                        user.setPassword(null); //设置密码前端不可见
                        RespBean ok = RespBean.ok("登录成功！", user);
                        String s = new ObjectMapper().writeValueAsString(ok); //转为json
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        RespBean respBean = RespBean.error("登录失败！");
                        if (e instanceof LockedException) {
                            respBean.setMsg("账户被锁定");
                        } else if (e instanceof CredentialsExpiredException) {
                            respBean.setMsg("密码过期");
                        } else if (e instanceof AccountExpiredException) {
                            respBean.setMsg("账户过期");
                        } else if (e instanceof DisabledException) {
                            respBean.setMsg("账户被禁用");
                        } else if (e instanceof BadCredentialsException) {
                            respBean.setMsg("用户名或密码输入错误");
                        }
                        String s = new ObjectMapper().writeValueAsString(respBean);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .permitAll() //表示和登录相关的接口都不需要认证就可以访问
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功!")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf()
                .disable(); //关闭csrf，防止不能使用postman
    }
}
