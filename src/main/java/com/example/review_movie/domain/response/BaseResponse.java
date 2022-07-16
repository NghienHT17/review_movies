package com.example.review_movie.domain.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse {
    private String code;
    private String message;
    private String token;
}
