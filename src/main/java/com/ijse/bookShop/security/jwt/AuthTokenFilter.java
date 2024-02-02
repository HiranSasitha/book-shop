package com.ijse.bookShop.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ijse.bookShop.security.UserDetailsServiceImpl;

import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.io.SerialException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter { // filter user request

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException,SerialException, java.io.IOException, ServletException{


        try{
            String jwt = parseJwt(request);

            if (jwt != null && jwtUtils.validateToken(jwt)){ // cheack jwt token validate

                String userName = jwtUtils.getUserNameFromJwtToken(jwt); // get username
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userName); //get userdeatils from username

                UsernamePasswordAuthenticationToken authntication  = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());  // userDetails.getAuthorities() can manage admin login,manager login

                authntication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authntication); // create securitycontxt
                

            }
        } catch( Exception e){

            System.err.println("cannot set user auth");

        }

        filterChain.doFilter(request, response);
    }


    public String parseJwt(HttpServletRequest request){   // bearer word remove 

        String authHeader = request.getHeader("Authorization");

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){ // first chechk have text in authHeader and then check it have tex bearer word

            return authHeader.substring(7); // reomve firs 7 index

        }

        return null;
    }

    
}

