package com.infoshareacademy.OAuth;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.appengine.auth.oauth2.AbstractAppEngineAuthorizationCodeCallbackServlet;

import java.io.IOException;

@WebServlet("/oauth2callback")
public class CallBack extends AbstractAppEngineAuthorizationCodeCallbackServlet {
OAuth o = new OAuth();
    @Override
    protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
            throws IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void onError(
            HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
            throws IOException {

        resp.getWriter().print("Error");

    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
        return null;
    }

    @Override
    protected String getRedirectUri(HttpServletRequest req) {

        return null;
    }


}
