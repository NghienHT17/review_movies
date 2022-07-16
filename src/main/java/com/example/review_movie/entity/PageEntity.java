package com.example.review_movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "page")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageEntity implements Serializable {

    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pageId;

    private String url;

    private String note;

}
