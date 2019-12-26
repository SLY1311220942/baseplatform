package com.sly.baseplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author SLY
 * @time 2019/12/17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // 放行路径
                .antMatchers("/css/**","/**").permitAll()
                // 其它路径需要校验
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
                //关闭CSRF
                .csrf().disable()
                // 配置登录页面路径并且允许全部人访问
                .formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/form")
                //成功登陆后跳转页面
                .defaultSuccessUrl("/index")
                .failureUrl("/loginError").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("123456").roles("USER")
                .and()
                .withUser("test").password("test123").roles("ADMIN");
    }
}
