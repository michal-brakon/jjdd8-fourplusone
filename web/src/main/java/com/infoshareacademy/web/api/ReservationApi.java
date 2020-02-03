package com.infoshareacademy.web.api;

import com.infoshareacademy.dto.ReservationDTO;
import com.infoshareacademy.service.ReservationService;
import com.infoshareacademy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Path("/reserve")
public class ReservationApi {

    private static final Logger logger = LoggerFactory.getLogger(ReservationApi.class.getName());

    @EJB
    ReservationService reservationService;

    @EJB
    UserService userService;

    @GET
    @Path("/{id}")
    public Response reserveBook(@PathParam("id") String id, @Context HttpServletRequest req) throws MessagingException, IOException {


        Long idParam = Long.parseLong(id);
        String email =(String) req.getSession().getAttribute("email");
        logger.info("email from req Session: {}", email);

        ReservationDTO reservation = new ReservationDTO();
        reservation.setBookId(idParam);
        reservation.setUserId(userService.findUserByEmail(email).getId());
        reservation.setBorrowDate(Timestamp.valueOf(LocalDateTime.now()));
        reservation.setExpiredTime(Timestamp.valueOf(LocalDateTime.now().plusMinutes(2)));

        reservationService.addReservation(reservation);

        return Response.ok().build();
    }
}
