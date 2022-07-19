package com.example.review_movie.service.Impl;

import com.example.review_movie.dto.login.LoginRequest;
import com.example.review_movie.dto.login.LoginResponse;
import com.example.review_movie.entity.TokenEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.repository.TokenRepository;
import com.example.review_movie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenRepository tokenRepository;

    private final UserRepository userRepository;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder baseENCODER = Base64.getUrlEncoder();

    public static String generateNewToken(){
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return baseENCODER.encodeToString(randomBytes);
    }

    public LoginResponse login(LoginRequest loginRequest){
        String userName = loginRequest.getEmail();
        String pass = loginRequest.getPassword();
        UserEntity userEntity = userRepository.findByEmail(userName);

        if (userEntity == null){
            return new LoginResponse(false,"can't not find user with email: "+userName, null);
        }

        if (!userEntity.getPassword().equals(pass)){
            return new LoginResponse(false, "Invalid password for email:"+ userName, null);
        }

        String token = generateNewToken();
        TokenEntity tokenEntity = new TokenEntity(null,token, new Date(), userEntity.getUserId());
        tokenRepository.save(tokenEntity);
        return new LoginResponse(true, null, token);
    }
}
