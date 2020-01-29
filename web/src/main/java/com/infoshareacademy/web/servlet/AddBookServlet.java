package com.infoshareacademy.web.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
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


@WebServlet("/admin/add-book")
public class AddBookServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "/admin-site/Admin-site.ftlh");

        dataModel.put("content", "/admin-site/add-book.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.error("Error while processing freemarker template ", e.getMessage());
        }
    }
}
