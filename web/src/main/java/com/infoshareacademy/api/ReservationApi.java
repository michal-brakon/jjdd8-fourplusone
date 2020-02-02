package com.infoshareacademy.api;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.dto.ReservationDTO;
import com.infoshareacademy.service.BookService;
import com.infoshareacademy.service.ReservationService;
import com.infoshareacademy.service.UserService;
import com.infoshareacademy.web.servlet.CoomingSoonServlet;
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
    BookService bookService;

    @EJB
    ReservationService reservationService;

    @EJB
    UserService userService;

    @GET
    @Path("/{id}")
    public Response reserveBook(@PathParam("id") String id,
                                @Context HttpServletRequest req) throws MessagingException, IOException {

//        Optional<String> emailOpt = Optional
//                .ofNullable(req.getSession().getAttribute("email").toString());
//        String email = emailOpt.get();


        id = id.replace(",", "");
        Long idParam = Long.parseLong(id);
        String email = req.getSession().getAttribute("email").toString();
        logger.info("email from req Session: {}", email);

        Book book = bookService.getById(idParam);

        ReservationDTO reservation = new ReservationDTO();
        reservation.setBookId(idParam);
        reservation.setUserId(userService.findUserByEmail(email).getId());
        reservation.setBorrowDate(Timestamp.valueOf(LocalDateTime.now()));
        reservation.setExpiredTime(Timestamp.valueOf(LocalDateTime.now().plusMinutes(2)));

        reservationService.addReservation(reservation);

        return Response.ok().build();
    }
}
