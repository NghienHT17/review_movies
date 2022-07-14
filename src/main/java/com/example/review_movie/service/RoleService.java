package com.example.review_movie.service;

import com.example.review_movie.entity.RoleEntity;

public interface RoleService {
    RoleEntity findByRole(String roleName);
}
