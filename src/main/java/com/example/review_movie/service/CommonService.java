package com.example.review_movie.service;

import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.entity.UserRoleEntity;
import com.example.review_movie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RolePageActionRepository rolePageActionRepository;

//    ConfigPasswordRequest configPass = new ConfigPasswordRequest();
    public boolean checkToken(String token, String url, String action){
        token = token.replace("Bearer ", "");
        if (token=="" || token == null) return false;
        UserEntity user = userRepository.findByToken(token);
        if (user == null ) return false;

        boolean found = false;
        long pageId = pageRepository.findByUrl(url).getPageId();
        long actionId = actionRepository.findByName(action).getActionId();
        long userId = user.getUserId();
        List<UserRoleEntity> roleList = userRoleRepository.findByIdUser(userId);
        for (UserRoleEntity userRole : roleList) {
            if (rolePageActionRepository.findByRoleIdAndPageIdAndActionId(userRole.getRoleId(), pageId, actionId) != null) {
                found = true;
                break;
            }
        }
        return found;
    }
}
