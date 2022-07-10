package com.example.review_movie.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class RoleEntity {
    @Id
    @GeneratedValue
    private int id;

    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "role")
    private Set<UserEntity> user;


}
