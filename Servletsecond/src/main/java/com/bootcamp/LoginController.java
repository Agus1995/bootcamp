package com.bootcamp;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logincontrol", urlPatterns = "/auth")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String un = req.getParameter("usernamae");
        String pw = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        Cookie ck = new Cookie("auth", un);
        ck.setMaxAge(600);
        if (un.equals("agus") & pw.equals("pwd")){
            resp.addCookie(ck);
            resp.sendRedirect("index.jsp");
            return;
        }else {
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            out.print("wrong username or password");
            rd.include(req,resp);
        }
    }
}
