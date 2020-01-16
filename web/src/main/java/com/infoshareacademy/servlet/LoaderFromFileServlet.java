package com.infoshareacademy.servlet;

import com.infoshareacademy.Book;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.ApiLoaderFromFile;
import com.infoshareacademy.service.BookService;
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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet ("/uploader")
@MultipartConfig
public class LoaderFromFileServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    BookDTO bookDTO;

    @Inject
    BookService bookService;

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

//        Part api = req.getPart("api");
//        String apiURL = "";
//        try {
//            apiURL = bookDTO.uploadApiFile(api).getName();
//        } catch (ApiFileNotFound apiFileNotFound) {
//            logger.warn(apiFileNotFound.getMessage());
//        }
        Part file = req.getPart("api");
        Set<BookDTO> books = new HashSet<>();
        try {
            books = bookDTO.parseBooksToDTO(bookDTO.uploadApiFile(file));
        } catch (ApiFileNotFound apiFileNotFound) {
            apiFileNotFound.printStackTrace();
        }
        bookService.addBooks(books);
    }
}
