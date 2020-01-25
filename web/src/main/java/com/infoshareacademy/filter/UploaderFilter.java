package com.infoshareacademy.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.ws.rs.HttpMethod.GET;

@WebFilter(
        filterName = "AuthorizationFilter",
        urlPatterns = {"/*"}

)
public class UploaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String role = servletRequest.getParameter("role");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if (httpRequest.getMethod().equalsIgnoreCase("GET")) {
            if (role == null || role.isEmpty() || !role.equals("admin")) {
                ((HttpServletResponse) servletResponse).sendRedirect("/");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
