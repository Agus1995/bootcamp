package com.bootcamp;

import javax.servlet.*;
import javax.servlet.Filter;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher view = servletRequest.getRequestDispatcher("/login.jsp");
        view.forward(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
