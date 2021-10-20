package com.abi.rest01.service;

import com.abi.rest01.domain.Person;
import com.abi.rest01.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    public Person create(PersonDTO personDTO);
    public List<PersonDTO> read();
    public Person read(int id);
    public Person update(PersonDTO personDTO);
    public void delete(int id);

}
