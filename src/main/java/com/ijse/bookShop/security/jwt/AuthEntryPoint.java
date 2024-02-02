 package com.ijse.bookShop.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class AuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,HttpServletResponse response,AuthenticationException authenticationException)throws IOException, java.io.IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error:unathorized");
    }
    // use user not loging and try enter show error
    
}
