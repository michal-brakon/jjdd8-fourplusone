package com.infoshareacademy.web.api;

import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.service.AdminManagement;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/management")
public class BookManagement {

    @Inject
    private AdminManagement adminManagement;

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") Long id) {
        return Response.ok().entity(adminManagement.remove(id)).build();
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, BookDTO bookDTO) {

        adminManagement.update(id, bookDTO);
        return Response.ok().entity(bookDTO).build();

    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(BookDTO bookDTO) {

        adminManagement.save(bookDTO);
        return Response.ok().entity(bookDTO).build();

    }


}