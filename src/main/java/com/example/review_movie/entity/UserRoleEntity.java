package com.example.review_movie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 10L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "user_id")
    private int userId;
}
