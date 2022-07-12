package com.example.review_movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private long userId;
    private String email;

    private Date joinDate;

    private String picLink;

    private String password;

    private String confirmPassword;

    private Date dob;


}
