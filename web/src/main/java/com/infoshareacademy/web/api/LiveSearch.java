package com.infoshareacademy.web.api;

import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.service.BookService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/search")
public class LiveSearch {

    @EJB
    private BookService bookService;

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTitle(@PathParam("param") String param) {

        List<BookView> bookViews = bookService.findByTitle(param);
      return Response.ok().entity(bookViews).build();
    }
}