package com.infoshareacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ApiDataInitializer {

    private final Logger logger = LoggerFactory.getLogger(ApiDataInitializer.class.getName());

    private static final String URI = "http://isa-proxy.blueazurit.com/books/audiobooks/";

    public String getApiFromUrl() {

        WebTarget webTarget = getBookClientTarget();
        String strResponse;
        try (Response response = webTarget.request().get()) {
            if (Response.Status.OK.equals(response.getStatusInfo())) {
                strResponse = response.readEntity(String.class);
                logger.info("Api status OK");
                return strResponse;
            }
            logger.warn("Connection with remote Api failed");
            int status = response.getStatus();
            throw new IllegalStateException("Error: " + status);
        }
    }

    private WebTarget getBookClientTarget() {
        Client client = ClientBuilder.newClient();
        return client.target(URI);
    }

}

