package com.minju.firstproject.constroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.minju.firstproject.service.MainService;

@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/hello")
    public String hello() {
        return mainService.hello();
    }
    
    @GetMapping("/jwt/{data}")
    public String getJwt(@PathVariable("data") String data
    ) {
        return mainService.getJwt(data);
    }
}
