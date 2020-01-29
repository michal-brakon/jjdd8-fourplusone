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
import java.util.Map;

@WebServlet("/admin/edit")
public class EditServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());


    @Inject
    private BookService bookService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param = req.getParameter("id");

        if (param == null || param.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        Long id = Long.valueOf(param);

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "/admin-site/Admin-site.ftlh");
        BookView bookView = bookService.getBookViewById(id);
        dataModel.put("content", "/admin-site/edit-book.ftlh");
        dataModel.put("book", bookView);

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            logger.error("Error while processing freemarker template ", e.getMessage());
        }
    }
}