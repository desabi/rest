package com.abi.rest01.service;

import com.abi.rest01.domain.Person;
import com.abi.rest01.dto.PersonDTO;
import com.abi.rest01.exception.ResourceNotFoundException;
import com.abi.rest01.repository.PersonRepositoryJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    PersonRepositoryJPA repository;

    @Override
    public Person create(PersonDTO personDTO) {
        Person personToSave = new Person(personDTO);
        Person personReturned = repository.save(personToSave);
        log.info("Guardando persona: " + personToSave);
        return personReturned;
    }

    @Override
    public List<PersonDTO> read() {
        log.info("Obteniendo lista de personas.");
        List<Person> entityList = repository.findAll();

        return entityList.stream().
                map(PersonDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Person read(int id) {
        log.info("Buscando persona con id: " + id);
        Optional<Person> personToRead = repository.findById(id);
        if(personToRead.isPresent()){
            log.info("Persona encontrada");
            return personToRead.get();
        }else {
            log.info("Persona no encontrada.");
            throw new ResourceNotFoundException("Persona con id: " + id+ " no encontrada");
        }
    }

    public Optional<Person> readb(int id){
        return repository.findById(id);
    }

    @Override
    public Person update(PersonDTO personDTO) {
        log.info("Actualizando persona con id: " + personDTO.getId());
        Person personToUpdate = new Person(personDTO);
        Person personUpdated = repository.save(personToUpdate);
        return personUpdated;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
        log.info("Borrando persona con id: " + id);
    }

}
