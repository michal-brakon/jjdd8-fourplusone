package com.infoshareacademy.web.servlet;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.BookService;
import com.infoshareacademy.service.RatingService;
import com.infoshareacademy.service.ReservationService;
import com.infoshareacademy.service.UserService;
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
import java.util.Optional;

@WebServlet("/single")
public class SingleBookServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(SingleBookServlet.class.getName());


    @Inject
    private BookService bookService;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ReservationService reservationService;

    @Inject
    private RatingService ratingService;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String param = req.getParameter("id");

        if (param == null || param.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        Long id = Long.valueOf(param);

        Book book = bookService.getById(id);

        boolean isReserved = true;
        boolean isRated = true;

        if (reservationService.findReservationByBook(book).isEmpty()) {
            isReserved = false;
        }
        if (req.getSession().getAttribute("email") == null)  {
            isReserved = true;
        }

        PrintWriter writer = resp.getWriter();

        Template template = templateProvider
                .getTemplate(getServletContext(),
                        "singlePage.ftlh");
        Map<String, Object> model = new HashMap<>();

        BookView bookView = bookService.getBookViewById(id);

        model.put("book", bookView);
        model.put("isReserved", isReserved);
        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.error("Template error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String param = req.getParameter("id");
        String scoreStr = req.getParameter("score");
        Long score = Long.valueOf(scoreStr);


        if (param == null || param.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        Long id = Long.valueOf(param);

        Book book = bookService.getById(id);

        boolean isReserved = true;
        boolean isRated = true;

        if (reservationService.findReservationByBook(book).isEmpty()) {
            isReserved = false;
        }
        if (req.getSession().getAttribute("email") != null)  {
            isReserved = false;
            String email = req.getSession().getAttribute("email").toString();
            ratingService.addRating(userService.findUserByEmail, bookService.getById(id), score);
        }

        PrintWriter writer = resp.getWriter();

        Template template = templateProvider
                .getTemplate(getServletContext(),
                        "singlePage.ftlh");
        Map<String, Object> model = new HashMap<>();

        BookView bookView = bookService.getBookViewById(id);

        model.put("book", bookView);
        model.put("isReserved", isReserved);
        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.error("Template error");
        }
    }
}