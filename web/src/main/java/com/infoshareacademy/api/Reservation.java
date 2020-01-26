package com.infoshareacademy.api;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.dto.ReservationDTO;
import com.infoshareacademy.service.BookService;
import com.infoshareacademy.service.ReservationService;
import org.hibernate.type.LocalDateTimeType;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Path("/reserve")
public class Reservation {

    @EJB
    BookService bookService;

    @EJB
    ReservationService reservationService;

    @GET
    @Path("/{id}")
    public Response reserveBook(@PathParam("id") String id,
                                @Context HttpServletRequest req) throws MessagingException {

//        Optional<String> emailOpt = Optional
//                .ofNullable(req.getSession().getAttribute("email").toString());
//        String email = emailOpt.get();


        id = id.replace(",", "");
        Long idParam = Long.parseLong(id);

        Book book = bookService.getById(idParam);

        ReservationDTO reservation = new ReservationDTO();
        reservation.setBookId(idParam);
        reservation.setUserId((long) 1);
        reservation.setBorrowDate(Timestamp.valueOf(LocalDateTime.now()));

        reservationService.addReservation(reservation);
//        List<String> recipients = new ArrayList<>();
//        recipients.add(email);
//        String subject = "Rezerwacja książki " + "\"" + book.getTitle() + "\"";
//        emailSenderService.sendMessage(recipients, subject);


        return Response.ok().build();
    }
}
