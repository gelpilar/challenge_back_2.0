package com.example.back_challenge.config.JWT;

import com.example.back_challenge.config.JwtService;
import com.example.back_challenge.config.UserDetailsCServices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsCServices userDetailsCServices;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsCServices userDetailsCServices) {
        this.jwtService = jwtService;
        this.userDetailsCServices = userDetailsCServices;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        final  String token = getTokenFromRequest(request);
       final  String username;

       if(token==null)
       {

           filterChain.doFilter(request,response);
           return;
       }

       username = jwtService.getUsernameFromToken(token);

       if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
       {
           UserDetails userDetails = userDetailsCServices.loadUserByUsername(username);

           if(jwtService.isValidToken(token,userDetails))
           {

               UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

               authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

               SecurityContextHolder.getContext().setAuthentication(authToken);

           }
       }
        filterChain.doFilter(request,response);


    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader != null&&authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        System.out.println("Token no presente o no válido en el encabezado Authorization.");

        return null;
    }

}
