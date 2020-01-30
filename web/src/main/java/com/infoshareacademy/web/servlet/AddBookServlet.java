package com.infoshareacademy.web.servlet;

import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.AdminManagement;
import com.infoshareacademy.service.UploaderService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/admin/add-book")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UploaderService uploaderService;

    @Inject
    private AdminManagement adminManagement;


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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String kind = req.getParameter("kind");
        String genre = req.getParameter("genre");
        String audio = req.getParameter("audio");
        boolean hasAudio = false;
        if (audio.equals("tak")) {
            hasAudio = true;
        }
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor(author);
        bookDTO.setTitle(title);
        bookDTO.setKind(kind);
        bookDTO.setGenre(genre);
        bookDTO.setHasAudio(hasAudio);
        Long id = adminManagement.save(bookDTO);
        String newBookUrl = "";

        Part cover = req.getPart("file");
        try {
            newBookUrl = uploaderService.saveFile(cover, "cover_" + id + ".jpg");
        } catch (Exception e) {
            LOGGER.error("File not found {}", e);
        }
        bookDTO.setCoverThumb(newBookUrl);
        bookDTO.setCover(newBookUrl);
        adminManagement.update(id,bookDTO);
        LOGGER.info("Ksiażka zapisana " + id + title + author);
        resp.sendRedirect("/single?id="+id);

    }
}
