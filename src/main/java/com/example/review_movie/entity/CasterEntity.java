package com.example.review_movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "caster")
@Entity
@Getter
@Setter
public class CasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int casterId;

    String acting;

    String imageLink;

    String casterName;
}
