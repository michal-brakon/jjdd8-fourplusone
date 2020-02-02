package com.infoshareacademy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "AuthorizationFilter",
        urlPatterns = {"/admin"}
)
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String role = String.valueOf(((HttpServletRequest) servletRequest).getSession().getAttribute("role"));
        if (role == null || role.isEmpty()) {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        } else if (role.equals("admin") || role.equals("superadmin")) {

            servletRequest.getRequestDispatcher("/admin").forward(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}