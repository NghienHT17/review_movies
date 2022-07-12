package com.example.review_movie.dto;

import com.example.review_movie.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String email;

    public UserResponseDto(UserEntity entity) {
        super();
        email = entity.getEmail();
    }
}
