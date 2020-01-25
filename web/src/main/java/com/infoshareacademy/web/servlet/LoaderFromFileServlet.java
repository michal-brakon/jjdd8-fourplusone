package com.infoshareacademy.web.servlet;

import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.BookService;
import com.infoshareacademy.service.ParserService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/uploader")
@MultipartConfig
public class LoaderFromFileServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookService bookService;

    @Inject
    private UploaderService uploaderService;

    @Inject
    private ParserService parserService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "upload-json.ftlh");
        String name = req.getParameter("name");
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", name);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part file = req.getPart("api");
        List<BookDTO> books = new ArrayList<>();
        try {
            String json = uploaderService.uploadApiFile(file);
            books = parserService.parse(json, BookDTO.class);
        } catch (ApiFileNotFound apiFileNotFound) {
            logger.warn(apiFileNotFound.getMessage());
        }
        bookService.addBooks(books);
        resp.sendRedirect("/");
    }
}
