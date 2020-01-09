package com.infoshareacademy.servlet;


import com.infoshareacademy.mapper.BookMapper;
import com.infoshareacademy.service.BookService;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/single")
public class SingleBook extends HttpServlet {
    @Inject
    private BookService bookService;

    @Inject
    private BookMapper bookMapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Long id = // pobrać z parametru

        public JsonObject getById (id) {
            return bookService.getById(id)
        }


    }
}
