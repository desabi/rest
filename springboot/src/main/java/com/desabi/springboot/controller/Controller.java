package com.desabi.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("springboot")
public class Controller {

    @GetMapping
    public ResponseEntity<String> index() {
        String text="Bienvenido ";
        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}
