package com.example.review_movie.api;

import com.example.review_movie.entity.ReviewEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.service.RoleService;
import com.example.review_movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity newUser){
        log.info("Create new user with email ={}", newUser.getEmail());
        return ResponseEntity.ok(new UserEntity(userService.create(newUser)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity updateUser){
        log.info("Update user with id = "+updateUser.getUserId());
        return ResponseEntity.ok(userService.updateUser(updateUser));
    }

    @GetMapping("/all/review-list/{id}")
    public List<ReviewEntity> getListReview(@PathVariable long id){
        log.info("Get all review with by user with id = "+id);
        return ResponseEntity.ok(userService.getAllReview(id))
    }
}
