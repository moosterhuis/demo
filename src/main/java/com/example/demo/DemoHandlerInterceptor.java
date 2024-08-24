package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class DemoHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final String requestUri = request.getRequestURI();
        if ("/error".equals(requestUri)) {
            System.out.println("##### Intercepted: " + requestUri);
            return true;
        } else if ("/".equals(requestUri)) {
            System.out.println("##### Intercepted: " + requestUri);
            response.sendRedirect(requestUri + "index.html");
            return false;
        } else if (!requestUri.endsWith(".html") && !requestUri.contains(".")) {
            System.out.println("##### Intercepted: " + requestUri);
            response.sendRedirect(requestUri + ".html");
            return false;
        }
        return true;
    }
}
