package com.example.review_movie.dto.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
