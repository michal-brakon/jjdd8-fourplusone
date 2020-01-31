package com.infoshareacademy.web.api;

import com.infoshareacademy.domain.view.BookView;
import com.infoshareacademy.domain.view.KindView;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.service.AdminManagement;
import com.infoshareacademy.service.KindService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
public class BookManagement {

    @Inject
    private KindService kindService;

    @Inject
    private AdminManagement adminManagement;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<BookView> bookViews = adminManagement.findAll();
        return Response.ok().entity(bookViews).build();
    }

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(BookDTO bookDTO) {

        adminManagement.save(bookDTO);
        return Response.ok().entity(bookDTO).build();
    }
    @GET
    @Path("kind")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllKinds(){
        List<KindView> kindViews = kindService.getAll();
     return Response.ok().entity(kindViews).build();
    }
}