package com.bootcamp;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "customer", urlPatterns = "/customerlist")
public class CustomerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer customer = new Customer();
        customer.setNama(req.getParameter("nama"));
        customer.setAlamat(req.getParameter("alamat"));

        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(customer);
        req.setAttribute("data",data);

        req.setAttribute("customer", customer);
        RequestDispatcher view = req.getRequestDispatcher("/read.jsp");

        view.forward(req,resp);
    }
}
