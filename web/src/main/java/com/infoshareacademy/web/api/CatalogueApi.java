package com.infoshareacademy.web.api;

import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/cat")
public class CatalogueApi {

    @Inject
    private BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<BookView> bookViewList = bookService.getAllBooksView();
        return Response.ok().entity(bookViewList).build();
    }

}
