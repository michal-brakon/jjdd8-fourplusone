package com.infoshareacademy.web.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
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
import java.util.Map;

@WebServlet("/soon")
public class CoomingSoonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CoomingSoonServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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









