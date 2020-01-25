package com.infoshareacademy.api;

import com.infoshareacademy.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/managemant")
public class BookManagement {

    @Inject
    private BookService bookService;

    @DELETE
    @Path("delete/{id}")
    public Response deleteBook(@PathParam("id") String id){


        Optional.ofNullable(id).orElseThrow();
        Long bookId = Long.parseLong(id);


        return Response.ok().entity(bookService.deleteBook(bookId)).build();


        }
}
