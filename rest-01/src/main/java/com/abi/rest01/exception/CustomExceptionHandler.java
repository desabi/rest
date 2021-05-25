package com.abi.rest01.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /* Bean Validation */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errores", errors);
        body.put("status", status.value());
        body.put("timestamp", new Date());

        ResponseEntity responseEntity = new ResponseEntity<>(body, headers, status);
        log.info("ResponseEntity: " + responseEntity);
        return responseEntity;
    }

    /* Metodo no permitido en un endpoint */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status.value() +" "+ status.getReasonPhrase());
        body.put("message", ex.getMessage());
        body.put("timestamp", new Date());

        ResponseEntity responseEntity = new ResponseEntity<>(body, headers, status);

        return responseEntity;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Recurso no encontrado");
        //body.put("status", status.value() +" "+ status.getReasonPhrase());
        body.put("timestamp", new Date());

        ResponseEntity responseEntity = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

        return responseEntity;
    }

}
