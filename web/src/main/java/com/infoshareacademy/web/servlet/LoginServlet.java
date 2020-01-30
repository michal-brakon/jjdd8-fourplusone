package com.infoshareacademy.web.servlet;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( value = "/login")

public class LoginServlet extends HttpServlet {
    @Inject
    private TemplateProvider templateProvider;
    private static final Logger logger = LoggerFactory.getLogger(DramaCatalogueServlet.class.getName());

    private static final Collection<String> SCOPES = Arrays.asList("email", "profile");
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private GoogleAuthorizationCodeFlow flow;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String state = new BigInteger(130, new SecureRandom()).toString(32);
        req.getSession().setAttribute("state", state);

        if (req.getAttribute("loginDestination") != null) {
            req
                    .getSession()
                    .setAttribute("loginDestination", (String) req.getAttribute("loginDestination"));
        } else {
            req.getSession().setAttribute("loginDestination", "/");
        }

        flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT,
                JSON_FACTORY,
                getServletContext().getInitParameter("jjdd8-fourplusone.clientID"),
                getServletContext().getInitParameter("jjdd8-fourplusone.clientSecret"),
                SCOPES)
                .build();


        String url =
                flow.newAuthorizationUrl()
                        .setRedirectUri(getServletContext().getInitParameter("jjdd8-fourplusone.callback"))
                        .setState(state)
                        .build();
        resp.sendRedirect(url);
        Template template = templateProvider.getTemplate(getServletContext(), "/login.ftlh");

        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
            logger.info("Error-info4");
            logger.debug("Error -debug4");
        }
    }
}
