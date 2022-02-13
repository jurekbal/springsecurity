package com.balwinski.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET ,"/" ,"/catalog/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout().logoutSuccessUrl("http://localhost:8080/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                    .withUser("user")
                    .password("{noop}pass")
                    .roles("USER")
                .and()
                    .withUser("admin")
                    .password("{noop}admin")
                    .roles("ADMIN");
    }
}
