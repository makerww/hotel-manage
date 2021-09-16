package com.mwq.manage.filter;

import com.mwq.manage.config.common.Context;
import com.mwq.manage.config.setting.SettingConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DELL
 */
@Order(0)
@Component
@Slf4j
public class TokenGlobalFilter implements Filter {

    @Resource
    private SettingConfig settingConfig;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();

        if (settingConfig.isAllowPath(path) || settingConfig.getIsDev()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = request.getParameter("access_token");
        token = StringUtils.isEmpty(token) ? request.getHeader("Authorization") : token;
        if (StringUtils.isEmpty(token)) {
            log.info("未登录!");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("NOT LOGGED IN!");
            return;
        } else {
            token = token.replace("Bearer ", "");
            log.debug("验证并解析token");
            if (token.length() != 10) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("TOKEN ERROR!");
                return;
            } else {
                Context.set(token);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}