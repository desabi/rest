package com.desabi.beanvalidation.controller;

import com.desabi.beanvalidation.dto.PersonaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @GetMapping("")
    public ResponseEntity<String> index() {
        String mensaje = "Página de inicio";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody PersonaRequest personaRequest){
        /*
        * Para manejar excepciones:
        * DefaultHandlerExceptionResolver
        * ResponseEntityExceptionHandler
        * */
        log.info("PersonaRequest: {}", personaRequest);
        return new ResponseEntity<>("Validacion OK", HttpStatus.OK);

    }

}
