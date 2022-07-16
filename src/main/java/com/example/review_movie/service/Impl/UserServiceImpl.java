package com.example.review_movie.service.Impl;


import com.example.review_movie.domain.response.ListUserResponse;
import com.example.review_movie.dto.UserRequestDto;
import com.example.review_movie.entity.ReviewEntity;
import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.repository.ReviewRepository;
import com.example.review_movie.repository.UserRepository;
import com.example.review_movie.service.CommonService;
import com.example.review_movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl extends CommonService {

    private  final String thisPage ="customer.html";
    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;


    public UserEntity findByEmail(String email) {
        return null;
    }


    public UserEntity findByConfirmationToken(String confirmationToken) {
        return null;
    }

    public UserEntity saveUserForMember(UserEntity user) {
        return null;
    }


    public UserEntity findById(long id) {
        return null;
    }


    public UserEntity updateUserByAdmin(long id, boolean isActive) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity updatingUser = userEntity.get();
            updatingUser.setActive(isActive);
            return userRepository.save(updatingUser);
        } else return null;
    }


    public UserEntity updateUser(UserRequestDto dto) {
        Optional<UserEntity> userEntity = userRepository.findById(dto.getUserId());
        if (userEntity.isPresent()) {

            UserEntity updatingUser = userEntity.get();
            System.err.println(updatingUser.getUserId());
            updatingUser.setEmail(dto.getEmail());
            updatingUser.setName(dto.getEmail());
            updatingUser.setPassword(dto.getPassword());
            updatingUser.setDob(dto.getDob());
            return userRepository.save(updatingUser);
        } else return null;

    }


    public ListUserResponse getListUser(String token) {
        ListUserResponse listUserResponse = new ListUserResponse();
        if (checkToken(token, thisPage, "read")){
            List<UserEntity> userList = userRepository.findAll();
            if (userList != null){
                listUserResponse.setCode("200");
                listUserResponse.setMessage("success");
                listUserResponse.setListUser(userList);
            }
            else {
                listUserResponse.setCode("201");
                listUserResponse.setMessage("error");
            }
        }
        return listUserResponse;
    }

    public void changePass(UserEntity user, String newPass) {

    }

//    @Override
//    public Page<UserEntity> getAllUser(Set<RoleEntity> roleSet, int page) {
//        return userRepository.findByRole(roleSet, PageRequest.of(page - 1, 6));
//    }


    public List<UserEntity> getListUserByRole(Set<RoleEntity> role) {
        return null;
    }


    public UserEntity saveUserForAdmin() {
        return null;
    }


    public List<ReviewEntity> getAllReview(long userId) {
//        UserEntity user = new UserEntity();
//        user = userRepository.findByUserId(userId);
        List<ReviewEntity> listReview = reviewRepository.findByUserId(userId);
//        if (user == null){
//            return null;
//        }
        return listReview;
    }


    public UserEntity create(UserRequestDto dto) {
        UserEntity userEntity = new UserEntity().toEntity(dto);
        return userRepository.save(userEntity);
    }
}
