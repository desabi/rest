package com.abi.exceptionhandling.service;

import com.abi.exceptionhandling.exception.person.PersonException;
import com.abi.exceptionhandling.request.PersonRequest;
import org.springframework.http.ResponseEntity;

public interface PersonService {
    ResponseEntity<Object> create(PersonRequest personRequest) throws PersonException;
    ResponseEntity<Object> read(Integer id) throws PersonException;
}
