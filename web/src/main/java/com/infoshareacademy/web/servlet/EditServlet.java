package com.infoshareacademy.web.servlet;

import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.AdminManagement;
import com.infoshareacademy.service.BookService;
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

@WebServlet("/admin/edit")
public class EditServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());


    @Inject
    private BookService bookService;

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private AdminManagement adminManagement;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String kind = req.getParameter("kind");
        String genre = req.getParameter("genre");
        String audio = req.getParameter("audio");
        String epoch = req.getParameter("epoch");

        boolean hasAudio = false;
        if (audio.equals("Dostępny")) {
            hasAudio = true;
        }
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor(author);
        bookDTO.setTitle(title);
        bookDTO.setKind(kind);
        bookDTO.setGenre(genre);
        bookDTO.setHasAudio(hasAudio);
        bookDTO.setEpoch(epoch);
        adminManagement.update(id, bookDTO);
        resp.sendRedirect("/admin");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = (String) req.getSession().getAttribute("name");
        String email = (String) req.getSession().getAttribute("email");
        String role = (String) req.getSession().getAttribute("role");
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
        if (email != null && !email.isEmpty()) {
            dataModel.put("logged", "yes");
            dataModel.put("email", email);
        } else {
            dataModel.put("logged", "no");}

        if(role != null && role.equals("User")) {
            dataModel.put("user", "yes");
        }
        else {dataModel.put("user", "no");}

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            logger.error("Error while processing freemarker template ", e.getMessage());
        }
    }
}