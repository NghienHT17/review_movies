package com.example.review_movie.service.Impl;


import com.example.review_movie.dto.UserRequestDto;
import com.example.review_movie.entity.ReviewEntity;
import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.repository.UserRepository;
import com.example.review_movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static jdk.internal.org.jline.utils.Colors.h;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
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
    public UserEntity updateUser(UserRequestDto dto) {
        Optional<UserEntity> userEntity = userRepository.findById(dto.getUserId());
        if (userEntity.isPresent()){
            UserEntity updatingUser = userEntity.get();
            updatingUser.setEmail(dto.getEmail());
            updatingUser.setName(dto.getEmail());
            updatingUser.setPassword(dto.getPassword());
            updatingUser.setDob(dto.getDob());
            return userRepository.save(updatingUser);
        }


        return userRepository.save(userEntity);
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
    public List<ReviewEntity> getAllReview(long id) {
        return null;
    }

    @Override
    public UserEntity create(UserRequestDto dto) {
        UserEntity userEntity = new UserEntity().toEntity(dto);
        return userRepository.save(userEntity);
    }
}
