package com.example.review_movie.entity;

import com.example.review_movie.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@AllArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String name;

    private Date dob;

    private boolean isActive;

    private String email;

    private Date joinDate;

    private String picLink;

    //    @JsonIgnore
    private String password;

    @Transient
//    @JsonIgnore
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> role;

    @Transient
//    @JsonIgnore
    private List<ReviewEntity> reviewList;


    public UserEntity toEntity(UserRequestDto dto) {
        this.email = dto.getEmail();
        return this;
    }
}
