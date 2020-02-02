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

@WebServlet("")
public class HelloServlet extends HttpServlet {
    @Inject
    private TemplateProvider templateProvider;


    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = (String) req.getSession().getAttribute("name");
        String email = (String) req.getSession().getAttribute("email");
        String role = (String) req.getSession().getAttribute("role");

        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        if (email != null && !email.isEmpty()) {
            dataModel.put("logged", "yes");
            dataModel.put("email", email);
        } else {
            dataModel.put("logged", "no");}

        if(role != null && role.equals("superadmin")) {
            dataModel.put("superadmin", "yes");
        }
        else {dataModel.put("superadmin", "no");}

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
            logger.info("Error-info4");
            logger.debug("Error -debug4");
        }
    }
}