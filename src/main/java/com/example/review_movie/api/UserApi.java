package com.example.review_movie.api;

import com.example.review_movie.dto.UserRequestDto;
import com.example.review_movie.dto.UserResponseDto;
import com.example.review_movie.entity.ReviewEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.service.RoleService;
import com.example.review_movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto newUserDto){
        log.info("Create new user with email ={}", newUserDto.getEmail());
        System.err.println("Create new user with email ={}"+ newUserDto.getEmail());
        return ResponseEntity.ok(new UserResponseDto(userService.create(newUserDto)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<UserEntity>> update(@RequestBody UserRequestDto updateUser){
        log.info("Update user with id = "+updateUser.getUserId());
        return ResponseEntity.ok(userService.updateUser(updateUser));
    }

    @GetMapping("/all/review-list/{id}")
    public ResponseEntity<List<ReviewEntity>> getListReview(@PathVariable long id){
        log.info("Get all review with by user with id = "+id);
        return ResponseEntity.ok(userService.getAllReview(id));
    }
}
