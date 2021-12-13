package com.abi.exceptionhandling.controller;

import com.abi.exceptionhandling.exception.person.PersonException;
import com.abi.exceptionhandling.request.PersonRequest;
import com.abi.exceptionhandling.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/index")
    public ResponseEntity<Object> index() {
        log.info("/persons/index OK.");
        return new ResponseEntity<>("/persons/index OK.", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> read(@PathVariable("id") Integer id) throws PersonException {
        log.info("person getById");
        return personService.read(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody PersonRequest personRequest) throws PersonException {
        return personService.create(personRequest);
    }
}
