package com.pikachu.takeaway.filter;


import com.alibaba.fastjson.JSON;
import com.pikachu.takeaway.common.R;
import com.pikachu.takeaway.entity.Employee;
import com.pikachu.takeaway.util.BaseContext;
import com.pikachu.takeaway.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 登录信息检查拦截器
 * @Author: 橙子
 * @Date: 2022/11/18 14:43
 */
@Slf4j
@WebFilter(filterName = "logincheckfilter", urlPatterns = "/*")//拦截的url
public class LoginCheckFilter implements Filter {

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取本次请求的url
        String requestURI = request.getRequestURI();

        //可以跳转的
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/*",
                "/backend/page/login/*",
                "/front/*"
        };
        boolean check = check(urls, requestURI);
        if (check) {
            filterChain.doFilter(request, response);
            log.info("放行的请求{}", requestURI);
            return;
        }
        //有登陆信息则放行
        if (request.getSession().getAttribute("employee") != null) {
            log.info("放行的请求{}", requestURI);

            Long emID = (Long) request.getSession().getAttribute("employee");
            BaseContext.setEmployeeId(emID);
            filterChain.doFilter(request, response);
            return;
        }
        //没有登录给前端返回数据
        log.info("afds{}",check);
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        log.info("用户未登录");
        log.info("路径{}" ,requestURI);
        return;
    }

    /**
     * 路径匹配，检查本次url是否放行
     *
     * @param uls
     * @param requesturl
     * @return
     */
    public boolean check(String[] uls, String requesturl) {
        for (String url : uls) {
            boolean match = PATH_MATCHER.match(url, requesturl);
            if (match) {
                return true;
            }
        }
        return false;
    }


}
