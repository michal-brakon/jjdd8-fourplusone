package com.infoshareacademy.api;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;

@Stateless
public class HealthCheck {

    @GET
    @Path("/api/health")
    public int HealthCheck() {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("/api/health");
        Response response = webTarget.request().get();
        System.out.println(response.getStatus());

        return response.getStatus();
    }
}
