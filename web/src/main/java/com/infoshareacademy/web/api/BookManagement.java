package com.infoshareacademy.web.api;

import com.infoshareacademy.domain.view.*;
import com.infoshareacademy.dto.BookDTO;
import com.infoshareacademy.service.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
public class BookManagement {

    @Inject
    private EpochService epochService;

    @Inject
    private GenreService genreService;

    @Inject
    private KindService kindService;

    @Inject
    private AuthorService authorService;

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
    public Response getAllKinds() {
        List<KindView> kindViews = kindService.getAll();
        return Response.ok().entity(kindViews).build();
    }

    @GET
    @Path("genre")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGenres() {
        List<GenreView> genreViews = genreService.getAll();
        return Response.ok().entity(genreViews).build();
    }

    @GET
    @Path("epoch")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEpoch() {
        List<EpochView> epochViews = epochService.getAll();
        return Response.ok().entity(epochViews).build();
    }

    @GET
    @Path("author/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByAuthorName(@PathParam("param") String param) {


        List<AuthorView> authorViews = authorService.authorNameLiveSearch(param);
        return Response.ok().entity(authorViews).build();
    }

}