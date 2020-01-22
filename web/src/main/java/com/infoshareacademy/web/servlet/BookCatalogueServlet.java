package com.infoshareacademy.web.servlet;

import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.BookService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

@WebServlet("/catalogue")
public class BookCatalogueServlet extends HttpServlet {

    @Inject
    private BookService bookService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String param = req.getParameter("bookNum");
        if (param == null || param.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        int num = Integer.parseInt(param);

        long next = num + 20;

        long previous = num - 20;

        PrintWriter writer = resp.getWriter();
        List<BookView> bookViewList = bookService.books333(num);

        Template template = templateProvider
                .getTemplate(getServletContext(),
                        "catalogue.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("catalogue", bookViewList);
        model.put("next", next);
        model.put("previous", previous);
        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}









