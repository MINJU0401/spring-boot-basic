package com.minju.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minju.board.entity.likyEntity;
import com.minju.board.entity.primaryKey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<likyEntity, LikyPk> {
    
}
