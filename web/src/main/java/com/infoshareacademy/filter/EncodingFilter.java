package com.infoshareacademy.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(
        filterName = "EncodingFilter",
        urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(EncodingFilter.class.getName());


    private final String codingType = "UTF-8";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.info("Coding type is set");
        request.setCharacterEncoding(codingType);
        response.setCharacterEncoding(codingType);

        filterChain.doFilter(request, response);
    }
}
