package com.abi.resttemplate.controller;


import com.abi.resttemplate.model.Person;
import com.abi.resttemplate.service.ServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

@RestController
public class RestTemplateController {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateController.class);

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping("/")
    public ResponseEntity<String> index() {
        String mensaje = "Rest Template Demo funcionando";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/home")
    public void home() throws JsonProcessingException {
        serviceLayer.home();
    }

    @PostMapping("/create")
    public void createPerson(@RequestBody Person person) {
        serviceLayer.createPerson(person);
    }

    @GetMapping("/read")
    public void readPersons() {
        serviceLayer.readPersons();
    }

    @GetMapping("/read/{id}")
    public void readPerson(@PathVariable("id") Integer id){
        serviceLayer.readPerson(id);
    }

    @PutMapping("/update")
    public void updatePerson(@RequestBody Person person) {
        serviceLayer.updatePerson(person);
    }
}
