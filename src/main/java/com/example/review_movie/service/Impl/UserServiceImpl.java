package com.example.review_movie.service.Impl;


import com.example.review_movie.entity.ReviewEntity;
import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.repository.UserRepo;
import com.example.review_movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepo userRepo;

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public UserEntity findByConfirmationToken(String confirmationToken) {
        return null;
    }

    @Override
    public UserEntity saveUserForMember(UserEntity user) {
        return null;
    }

    @Override
    public UserEntity findById(long id) {
        return null;
    }

    @Override
    public UserEntity updateUserByAdmin(long id, boolean isActive) {
        return null;
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return null;
    }

    @Override
    public void changePass(UserEntity user, String newPass) {

    }

    @Override
    public Page<UserEntity> getAllUser(Set<RoleEntity> role, int page) {
        return null;
    }

    @Override
    public List<UserEntity> getListUserByRole(Set<RoleEntity> role) {
        return null;
    }

    @Override
    public UserEntity saveUserForAdmin() {
        return null;
    }

    @Override
    public UserEntity create(UserEntity newUser) {
        UserEntity _user = new UserEntity();
        _user.setEmail(newUser.getEmail());
        _user.setDob(newUser.getDob());
        _user.setRole("user");

        return userRepo.save(_user);
    }

    @Override
    public List<ReviewEntity> getAllReview(long id) {
        return null;
    }
}
