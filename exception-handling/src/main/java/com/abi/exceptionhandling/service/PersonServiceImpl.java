package com.abi.exceptionhandling.service;

import com.abi.exceptionhandling.entity.Person;
import com.abi.exceptionhandling.exception.person.PersonError;
import com.abi.exceptionhandling.exception.person.PersonException;
import com.abi.exceptionhandling.repository.PersonRepository;
import com.abi.exceptionhandling.request.PersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public ResponseEntity<Object> create(PersonRequest personRequest) throws PersonException {

        return null;
    }

    @Override
    public ResponseEntity<Object> read(Integer id) throws PersonException {
        Person person = personRepository.getById(id);
        log.info("person: {}", person);
        if(person == null) {
            throw new PersonException(PersonError.ERROR_NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
