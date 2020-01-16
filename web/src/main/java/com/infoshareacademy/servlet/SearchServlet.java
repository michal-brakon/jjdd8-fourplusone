package com.infoshareacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws
            ServletException, IOException {
        String search = request.getParameter("search");
        response.setContentType("text/html");
        if (!((search.trim()).equals(""))) {
         //   String searchString = getSearchResult(search);
          //  response.getWriter().write(searchString);
        } else
            response.getWriter().write("");
    }


}
