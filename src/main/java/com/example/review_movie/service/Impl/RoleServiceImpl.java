package com.example.review_movie.service.Impl;

import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.repository.RoleRepository;
import com.example.review_movie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepo;
    @Override
    public RoleEntity findByRole(String roleName) {
        return roleRepo.findByRoleName(roleName);
    }
}
