package com.infoshareacademy.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/search")
public class LiveSearch {


    @POST
    @Path("/title/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTitle(@PathParam("param") String param){



        return
    }


}
