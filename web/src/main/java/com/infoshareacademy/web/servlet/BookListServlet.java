package com.infoshareacademy.web.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.AdminManagement;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/list-book")
public class BookListServlet extends HttpServlet {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AdminManagement adminManagement;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "/admin-site/Admin-site.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("content", "/admin-site/booklist.ftlh");
        dataModel.put("books", adminManagement.findAll());

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.error("Issue with processing Freemarker template.{}", e.getMessage());
        }

    }

}
