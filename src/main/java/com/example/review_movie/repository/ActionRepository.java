package com.example.review_movie.repository;


import com.example.review_movie.entity.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity,Long> {
    ActionEntity findByName(String name);


}
