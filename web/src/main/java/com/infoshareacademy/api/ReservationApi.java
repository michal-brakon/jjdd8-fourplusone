package com.infoshareacademy.api;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.dto.ReservationDTO;
import com.infoshareacademy.service.BookService;
import com.infoshareacademy.service.ReservationService;

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
import java.util.Optional;

@Path("/reserve")
public class ReservationApi {

    @EJB
    BookService bookService;

    @EJB
    ReservationService reservationService;

    @GET
    @Path("/{id}")
    public Response reserveBook(@PathParam("id") String id,
                                @Context HttpServletRequest req) throws MessagingException, IOException {

        Optional<String> emailOpt = Optional
                .ofNullable(req.getSession().getAttribute("email").toString());
        String email = emailOpt.get();

        id = id.replace(",", "");
        Long idParam = Long.parseLong(id);

        Book book = bookService.getById(idParam);

        ReservationDTO reservation = new ReservationDTO();
        reservation.setBookId(idParam);
        reservation.setUserId((long) 1);
        reservation.setBorrowDate(Timestamp.valueOf(LocalDateTime.now()));
        reservation.setExpiredTime(Timestamp.valueOf(LocalDateTime.now().plusMinutes(2)));

        reservationService.addReservation(reservation);


        return Response.ok().build();
    }
}
