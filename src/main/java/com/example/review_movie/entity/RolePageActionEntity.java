package com.example.review_movie.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_page_action")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolePageActionEntity implements Serializable {

    private static final long serialVersionUID = 8L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolePageActionId;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "page_id")
    private int pageId;

    @Column(name = "action_id")
    private int actionId;
}



