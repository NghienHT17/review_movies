package com.example.review_movie.service;

import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;


public interface UserService {

    UserEntity findByEmail(String email);
    UserEntity findByConfirmationToken(String confirmationToken);
    UserEntity saveUserForMember(UserEntity user);
    UserEntity findById(long id);
    UserEntity updateUser(UserEntity user);

    UserEntity updateUserByAdmin(long id, boolean isActive);
    void changePass(UserEntity user, String newPass);
    Page<UserEntity> getAllUser(Set<RoleEntity> role, int page);
    List<UserEntity> getListUserByRole(Set<RoleEntity> role);
    UserEntity saveUserForAdmin ();

    Object create(UserEntity newUser);
}
