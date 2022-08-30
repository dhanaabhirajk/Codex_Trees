package com.codextrees.web.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class UnauthenticatedRequestHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        if (request.getServletPath().startsWith("/admin/")) {
//            response.setStatus(403);
//        } else {
//        	//response.setStatus(403);
//            response.sendRedirect("/oauth2/authorization/google");
//        }
    	response.setStatus(403);
    }
}
