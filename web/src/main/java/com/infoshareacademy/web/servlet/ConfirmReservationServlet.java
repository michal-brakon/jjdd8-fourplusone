package com.infoshareacademy.web.servlet;


import com.infoshareacademy.domain.entity.Reservation;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.ReservationService;
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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/confirm")
public class ConfirmReservationServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    ReservationService reservationService;

    private static final Logger logger = LoggerFactory.getLogger(ConfirmReservationServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "confirm-error.ftlh");

        String token = req.getParameter("token");

        String message = reservationService
                .findReservationByToken(token)
                .map(this::doLogicjkfadshl)
                .orElseGet(() -> "Link nieprawidłowy");


        Map<String, Object> model = new HashMap<>();
        model.put("message", message);
        try {
            template.process(model, resp.getWriter());
        } catch (
                TemplateException e) {
            logger.error("Template error");
        }
    }

    private String doLogicjkfadshl(Reservation reservation) {

        if (Timestamp.valueOf(LocalDateTime.now())
                .before(reservation.getExpirationTime())) {
            reservationService.confirm(reservation);
            return "Rezerwacja potwierdzona pomyślnie";
        } else  {
            return "Czas ważności linku potwierdzającego upłynął";

        }
        }

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String token = req.getParameter("token");
//        Reservation reservation = reservationService.findReservationByToken(token).ifPresent(this::doLogicjkfadshl);
//
//
//        //Timestamp timestamp = reservation.getCreateTimestamp();
//        String message = "";
//        Template template = templateProvider.getTemplate(getServletContext(), "confirm-error.ftlh");
//
//
//        if ((reservationService.findReservationByToken(token)).isPresent()) {
//            if (Timestamp.valueOf(LocalDateTime.now())
//                    .before(reservationService.findReservationByToken(token).get().getExpirationTime())) {
//                reservationService.confirm(reservationService.findReservationByToken(token).get());
//                message = "Rezerwacja potwierdzona pomyślnie";
//            } else if (Timestamp.valueOf(LocalDateTime.now()).after(reservationService.findReservationByToken(token).get().getExpirationTime())) {
//                message = "Czas ważności linku potwierdzającego upłynął";
//                //reservationService.removeReservation(reservation);
//            }
//        } else {
//            message = "Link nieprawidłowy";
//            //reservationService.removeReservation(reservation);
//        }
//        Map<String, Object> model = new HashMap<>();
//        model.put("message", message);
//        try {
//            template.process(model, resp.getWriter());
//        } catch (TemplateException e) {
//            logger.error("Template error");
//        }
//    }
    }

