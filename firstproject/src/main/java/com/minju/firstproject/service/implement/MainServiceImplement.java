package com.minju.firstproject.service.implement;

import org.springframework.stereotype.Component;

import com.minju.firstproject.service.MainService;

@Component
public class MainServiceImplement implements MainService {

    @Override
    public String hello() {
        return "Hello";
    }
    
}
