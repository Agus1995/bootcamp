package com.bootcamp;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher view = servletRequest.getRequestDispatcher("/WEB-INF/403.jsp");
        view.forward(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
