package com.infoshareacademy.web.servlet;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.infoshareacademy.OAuth.GoogleAuthHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;

@WebServlet("/oauth2callback")
public class OAuth2CallBack extends HttpServlet {

    GoogleAuthHelper googleAuthHelper = new GoogleAuthHelper();

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("REQEST: {}", req.getRequestURI());
        String  param = req.getParameter("code");
        JsonObject userInfoJson = Json.createReader(new StringReader(param)).readObject();

        req.getSession().setAttribute("userID", param);

    }


}

