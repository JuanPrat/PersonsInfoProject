package com.docker.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/greet")
    ResponseEntity<String> greet(){
        return ResponseEntity.ok().body("Hello World");
    }
}
