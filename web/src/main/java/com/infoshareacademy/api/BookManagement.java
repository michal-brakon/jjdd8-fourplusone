package com.infoshareacademy.api;

import com.infoshareacademy.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/managemant")
public class BookManagement {

    @Inject
    private BookService bookService;
    private Enum REJECTED;

    @DELETE
    @Path("delete/{id}")
    public Response deleteBook(@PathParam("id") String id) {


        if (id.matches("^[0-9]*$")) {
            Long bookId = Long.parseLong(id);
            if(bookId<=bookService.) {
                return Response.ok().entity(bookService.deleteBook(bookId)).build();
            }
        }
        return Response.ok().entity(REJECTED).build();
    }
}