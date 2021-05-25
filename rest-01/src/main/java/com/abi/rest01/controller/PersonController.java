package com.abi.rest01.controller;

import com.abi.rest01.domain.Person;
import com.abi.rest01.dto.PersonDTO;
import com.abi.rest01.exception.ResourceNotFoundException;
import com.abi.rest01.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService service;

    @GetMapping("/")
    public ResponseEntity<String> index() {
        String message = "Pagina de inicio";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/create")
    public ResponseEntity<Person> create(@Valid @RequestBody PersonDTO personDTO) {
        Person person = service.create(personDTO);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> listPersonsDTO = service.read();
        return new ResponseEntity<>(listPersonsDTO, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") int id) {
        Person person = service.read(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@Valid @RequestBody PersonDTO personDTO) {
        Person person = service.read(personDTO.getId());

        if (person.getId() > 0) {
            personDTO.setId(person.getId());
            Person personUpdated = service.update(personDTO);
            return new ResponseEntity<>(personUpdated, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(new Person(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Person person = service.read(id);

        if (person.getId() > 0) {
            service.delete(id);
            return ResponseEntity.ok("Persona borrada, id: " + person.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Registro con id: " + id + " no encontrado");
        }

    }
}
