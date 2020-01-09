package com.infoshareacademy.servlet;


import com.infoshareacademy.mapper.SingleBookMapper;
import com.infoshareacademy.service.SingleBookService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/single")
public class SingleBook extends HttpServlet {
    @Inject
    private SingleBookService singleBookService;

    @Inject
    private SingleBookMapper singleBookMapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


    }
}
