package com.infoshareacademy.servlet;

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

@WebServlet(urlPatterns = "")
public class HelloServlet extends HttpServlet {
    @Inject
    private TemplateProvider templateProvider;


    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class.getName());  //!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Error-info1");
        logger.debug("Error-debug1");

        Template template = templateProvider.getTemplate(getServletContext(), "main.ftlh");
        String name = req.getParameter("name");
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", name);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
            logger.info("Error-info4");
            logger.debug("Error -debug4");
        }
        logger.info("Error-info5");
        logger.debug("Error -debug5");
    }

}