package com.example.review_movie.domain.response;

import com.example.review_movie.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ListUserResponse extends BaseResponse{
    List<UserEntity> listUser;

}
