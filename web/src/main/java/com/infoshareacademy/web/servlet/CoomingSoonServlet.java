package com.infoshareacademy.web.servlet;

import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/sracz")
public class CoomingSoonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CoomingSoonServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Template template = templateProvider
                .getTemplate(getServletContext(),
                        "comingSoon.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("soon", writer);
        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.error("Template error");
        }
    }
}









