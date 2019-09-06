package com.carlme.web.component.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器案例
 */
@Slf4j
public class ListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(">>>>>>>>>>>>>>>contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info(">>>>>>>>>>>>>>>contextDestroyed...当前web项目销毁");
    }

}
