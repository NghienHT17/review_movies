package com.example.review_movie.api;

import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import com.example.review_movie.service.RoleService;
import com.example.review_movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminApi {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/all/user")
    public Page<UserEntity> getAllUser(@RequestParam(defaultValue = "1") int page){
        Set<RoleEntity> roleSet = new HashSet<>();
        roleSet.add(roleService.findByRole("user"));
        return userService.getAllUser(roleSet, page);
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable("id") Long id,@RequestBody boolean isActive){
        log.info("Update activate user with ID = "+id);
        return ResponseEntity.ok(userService.updateUserByAdmin(id, isActive));
    }

}