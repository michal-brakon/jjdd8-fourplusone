package com.infoshareacademy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
        (filterName = "AuthorizationFilter",
                urlPatterns = {"/*"}
        )
public class AuthorizationFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class.getName());


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String role = servletRequest.getParameter("role");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (role == null || role.isEmpty()) {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        } else if (role.equals("admin")|| role.equals("superAdmin")) {
            ((HttpServletResponse) servletResponse).sendRedirect("/admin");
        } else if (role.equals("user")) {
            ((HttpServletResponse) servletResponse).sendRedirect("/user");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}