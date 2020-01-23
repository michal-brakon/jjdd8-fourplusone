//package com.infoshareacademy.filter;
//
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter(
//        filterName = "CatalogueParamFilter",
//        urlPatterns = {"/catalogue"}
//)
//public class CatalogueParamFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//        int bookNum = Integer.parseInt(filterConfig.getInitParameter("bookNum"));
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
