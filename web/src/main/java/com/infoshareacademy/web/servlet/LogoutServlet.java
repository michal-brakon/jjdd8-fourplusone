package com.infoshareacademy.web.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(name = "logout", value = "/logout")

public class LogoutServlet extends HttpServlet {
  @Inject
  private TemplateProvider templateProvider;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    HttpSession session =  req.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    req.getSession();

    Template template = templateProvider.getTemplate(getServletContext(), "/logout.ftlh");

    PrintWriter printWriter = resp.getWriter();
    Map<String, Object> dataModel = new HashMap<>();
  }
}