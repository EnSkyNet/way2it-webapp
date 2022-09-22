package com.way2it.yk.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ShopFilter", servletNames = "ShopServlet")

public class ShopFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Request host is: " + servletRequest.getRemoteHost());
        System.out.println("Protocol host is: " + servletRequest.getProtocol());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
