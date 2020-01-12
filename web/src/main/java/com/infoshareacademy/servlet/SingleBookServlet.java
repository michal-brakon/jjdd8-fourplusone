package com.infoshareacademy.servlet;


import com.infoshareacademy.dto.SingleBookFullDTO;
import com.infoshareacademy.entity.Book;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.mapper.BookMapper;
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
import java.util.Map;

@WebServlet("/single")
public class SingleBookServlet extends HttpServlet {

    @Inject
    private BookService bookService;

    @Inject
    SingleBookFullDTO singleBookFullDTO;

    @Inject
    BookMapper bookMapper;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String param = req.getParameter("id");

        if (param == null || param.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        Long id = Long.valueOf(param);

        bookMapper.getById(id);








//        Servlet natomiast, przyjmuje HttpServletRequest, następnie sam bądź za pomocą jakiegoś beana RequestScoped przepisuje HttpServletRequest.getParameter na DTO i wysyła go do service.

//        Servlet również przyjmuje od service DTO i następnie samodzielnie bądź za pomocą beana RequestScoped przepisuje jeden lub więcej DTO na mapę modelu danych Freemarkera.

        Book book = bookService.getById(id);

        PrintWriter writer = resp.getWriter();

        Template template = templateProvider
                .getTemplate(getServletContext(),
                        "singlePage.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (book != null) {
            model.put("book", book);
            try {
                template.process(model, writer);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            model.put("errorMessage", "Book not found");
            try {
                template.process(model, writer);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
}