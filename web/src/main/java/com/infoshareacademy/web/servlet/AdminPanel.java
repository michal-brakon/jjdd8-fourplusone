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

@WebServlet("/admin")
public class AdminPanel extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getSession().getAttribute("name");
        String email = (String) req.getSession().getAttribute("email");
        String role = (String) req.getSession().getAttribute("role");

        Template template = templateProvider.getTemplate(getServletContext(), "/admin-site/Admin-site.ftlh");

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        if (email != null && !email.isEmpty()) {
            dataModel.put("logged", "yes");
            dataModel.put("email", email);
        } else {
            dataModel.put("logged", "no");}

        if(role != null && role.equals("User")) {
            dataModel.put("user", "yes");
        }
        else {dataModel.put("user", "no");}

        dataModel.put("content", "/admin-site/most-reserved-author.ftlh");

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException tm) {
            logger.error("Error in the template proccesing {}", tm);
        }
    }
}