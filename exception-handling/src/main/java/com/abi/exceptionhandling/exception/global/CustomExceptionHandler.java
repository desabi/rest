package com.abi.exceptionhandling.exception.global;

import com.abi.exceptionhandling.exception.person.PersonException;
import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("status", status.value());
//        body.put("code", 101);
//        body.put("message", ex.getMessage());
//        body.put("timestamp", new Date());
//
//        ResponseEntity responseEntity = new ResponseEntity<>(body, headers, status);
//
//        return responseEntity;
//    }

    private ResponseEntity<ExceptionResponse> getErrorDatosEntrada() {
        GlobalError errorDatosEntrada = GlobalError.ERROR_DATOS_ENTRADA;

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(errorDatosEntrada.getStatus());
        exceptionResponse.setCode(errorDatosEntrada.getCode());
        exceptionResponse.setMessage(errorDatosEntrada.getMessage());
        exceptionResponse.setTimeStamp(errorDatosEntrada.getTimeStamp());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.valueOf(exceptionResponse.getStatus()));
    }

    // errores globales
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupportedException() {
        log.error("HttpRequestMethodNotSupportedException");
        return getErrorDatosEntrada();
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ExceptionResponse> handleJsonParseException() {
        log.error("JsonParseException");
        return getErrorDatosEntrada();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        log.error("{}", errores);
        return getErrorDatosEntrada();
    }
    // error para servicio persona
    @ExceptionHandler(PersonException.class)
    public ResponseEntity<ExceptionResponse> handlePersonException(PersonException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(ex.getStatus());
        exceptionResponse.setCode(ex.getCode());
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setTimeStamp(ex.getTimeStamp());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.valueOf(exceptionResponse.getStatus()));
    }

    // error para servicio x

}
