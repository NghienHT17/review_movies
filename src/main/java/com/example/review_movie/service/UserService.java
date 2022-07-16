package com.example.review_movie.service;

import com.example.review_movie.domain.response.ListUserResponse;
import com.example.review_movie.dto.UserRequestDto;
import com.example.review_movie.entity.ReviewEntity;
import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;


public interface UserService extends CommonService {

    UserEntity findByEmail(String email);

    UserEntity findByConfirmationToken(String confirmationToken);

    UserEntity saveUserForMember(UserEntity user);

    UserEntity findById(long id);

    UserEntity updateUser(UserRequestDto user);

    UserEntity updateUserByAdmin(long id, boolean isActive);

    void changePass(UserEntity user, String newPass);

//    Page<UserEntity> getAllUser(Set<RoleEntity> roleName, int page);
    public ListUserResponse getListUser(String token);

    List<UserEntity> getListUserByRole(Set<RoleEntity> role);

    UserEntity saveUserForAdmin();

    UserEntity create(UserRequestDto newUser);

    List<ReviewEntity> getAllReview(long id);
}
