package com.carlme.web.component.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 存储 栏目 节目 视频id
 */
@Slf4j
@Component
public class IdFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String programaId = req.getParameter("programaId");
        String itemId = req.getParameter("itemId");
        String videoId = req.getParameter("videoId");
        log.debug(">>>>>>>>>>>>>>>存储id>>>>>>>>>>>>>>>programaId:{}>>>>>>>>>>>>>>>itemId:{}>>>>>>>>>>>>>>>videoId:{}",programaId,itemId,videoId);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
