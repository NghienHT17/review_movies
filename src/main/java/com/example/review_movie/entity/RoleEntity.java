package com.example.review_movie.entity;

//import net.minidev.json.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class RoleEntity {
    @Id
    @GeneratedValue
    private long id;

    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "role")
    private Set<UserEntity> user;

    public RoleEntity(String roleName) {
        this.roleName = roleName;
    }

}
