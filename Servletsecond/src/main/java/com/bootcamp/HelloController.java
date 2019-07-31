package com.bootcamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloController  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().append("<h1> Hello </h1>").append(req.getContextPath());
        resp.getWriter().append("Served at: Hello").append(req.getContextPath());

/*
        resp.setContentType("text/html");
        resp.getWriter().write("<p> Agus Wibawa </p>");*/
    }
}
