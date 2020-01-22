package com.infoshareacademy.web.api;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;

@Path("/api/health")
public class HealthCheck {

    @GET
    public int HealthCheck() {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("/api/health");
        Response response = webTarget.request().get();
        System.out.println(response.getStatus());

        return response.getStatus();
    }
}
