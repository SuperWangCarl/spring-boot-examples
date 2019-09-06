package com.carlme.web.component.config;

import com.carlme.web.component.filter.FilterDemo;
import com.carlme.web.component.filter.IdFilter;
import com.carlme.web.component.listener.ListenerDemo;
import com.carlme.web.component.servlet.ServletDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@Component
public class ServerConfig {

    @Autowired
    private IdFilter idFilter;
    //注册过滤器
    @Bean
    public FilterRegistrationBean idFilterRegister(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(idFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

    //注册三大组件
    //注册servlet
    //@Bean
    public ServletRegistrationBean servletDemo(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletDemo(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    //注册过滤器
    //@Bean
    public FilterRegistrationBean filterDemo(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FilterDemo());
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

    //注册监听器
    //@Bean
    public ServletListenerRegistrationBean listenerDemo(){
        ServletListenerRegistrationBean<ListenerDemo> registrationBean = new ServletListenerRegistrationBean<>(new ListenerDemo());
        return registrationBean;
    }
}
