package org.example.springsecurity11.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class RequestValidationBeforeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("✅ RequestValidationBeforeFilter: Request blev opsnappet!");

        // Fortsæt videre i kæden
        filterChain.doFilter(request, response);
    }
}
