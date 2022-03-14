package com.exemple.gestion_employer1.medlware;

import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@WebFilter(urlPatterns = { "/admin/*" })
public class FilterParen implements Filter{
    public  void init(FilterConfig filterConfig) {
        System.out.println("Good morning!");

    }

    public  void destroy() {
        System.out.println("LogFilter destroy!");
    }


    public  void doFilter(ServletRequest request, ServletResponse response,
                          FilterChain filterChain)
            throws IOException, ServletException {



        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("email") != null);

        if (isLoggedIn ) {

            filterChain.doFilter(request, response) ;

        }else {
            System.out.println("not allowed");
            httpResponse.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Sorry you don't have access!");


        }


    }
}
