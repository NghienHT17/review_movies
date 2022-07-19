package com.example.review_movie.config.security;

import com.example.review_movie.entity.TokenEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.repository.TokenRepository;
import com.example.review_movie.repository.UserRepository;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)

public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {



        if (request.getMethod().equals("OPTIONS")){
            filterChain.doFilter(request,response);
            return;
        }

        if (request.getRequestURI().contains("/auth")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = request.getHeader("authentication");
        if (token == null){
            log.info("token header null");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        TokenEntity tokenEntity1 = tokenRepository.findByToken(token);
        if (tokenEntity1 == null){
            log.info("tokenEntity null with token: {}", token);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        //Todo check token expired
        UserEntity user =userRepository.findByUserId(tokenEntity1.getUserId());
        if (user == null){
            log.info("usser Entity null with id : {}", tokenEntity1.getUserId());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        //Set user to security context

        String role = "ROLE_ADMIN";
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(),"", List.of(grantedAuthority));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        System.err.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        filterChain.doFilter(request,response);
    }
}
