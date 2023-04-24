package com.minju.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minju.firstproject.entity.ExampleEntity;

@Repository
public interface ExampleRopository extends JpaRepository<ExampleEntity, Integer> {
    
}
