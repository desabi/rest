package com.desabi.beanvalidation.controller;

import com.desabi.beanvalidation.dto.ProductoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

    @GetMapping("")
    public ResponseEntity<String> index() {
        String mensaje = "Productos: página de inicio";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody ProductoRequest productoRequest){
        /*
         * Para manejar excepciones:
         * DefaultHandlerExceptionResolver
         * ResponseEntityExceptionHandler
         * */
        log.info("Producto Request {}", productoRequest);
        return new ResponseEntity<>("Validacion Producto OK", HttpStatus.OK);
    }

}
