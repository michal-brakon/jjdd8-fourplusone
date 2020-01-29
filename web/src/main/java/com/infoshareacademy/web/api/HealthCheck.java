package com.infoshareacademy.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/health")
public class HealthCheck {

    @GET
    public int HealthCheck() {
        return Response.Status.OK.getStatusCode();
    }
}
