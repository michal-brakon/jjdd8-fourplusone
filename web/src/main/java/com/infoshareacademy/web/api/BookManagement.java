package com.infoshareacademy.web.api;

import com.infoshareacademy.service.AdminManagement;
import com.infoshareacademy.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/managemant")
public class BookManagement {

    @Inject
    private BookService bookService;

    @Inject
    private AdminManagement adminManagement;
    private Enum REJECTED;

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") Long id) {


        return Response.ok().entity(adminManagement.remove(id)).build();

    }
}