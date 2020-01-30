package com.infoshareacademy.web.servlet;


import com.infoshareacademy.service.ReservationService;
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

@WebServlet("/confirm")
public class ConfirmReservationServlet extends HttpServlet {

    @Inject
    ReservationService reservationService;

    private static final Logger logger = LoggerFactory.getLogger(ConfirmReservationServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = req.getParameter("token");
        Timestamp timestamp = reservationService.findReservationByToken(token).get().getCreateTimestamp();

        if ((reservationService.findReservationByToken(token)).isPresent()
                && Timestamp.valueOf(LocalDateTime.now())
                .after(reservationService.findReservationByToken(token)
                .get().getExpirationTime()))    {



        }
    }


}
