package com.abi.resttemplate.service;

import com.abi.resttemplate.model.Person;
import com.abi.resttemplate.model.PersonList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLayer {

    private static final Logger log = LoggerFactory.getLogger(ServiceLayer.class);

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8090/person";

    public void home() {
        ResponseEntity<String> homeResponse = restTemplate.getForEntity(url, String.class);
        log.info("Respuesta de persona home: {}", homeResponse);
    }

    public void createPerson(Person person){
        String urlCreate = url + "/create";
        HttpEntity<Person> request = new HttpEntity<>(person);
        restTemplate.postForObject(urlCreate, request, Person.class);
    }

    public void readPersons() {
        String urlRead = url + "/read";

        List<ResponseEntity<Person[]>> responseEntities = Arrays.asList(restTemplate.getForEntity(urlRead, Person[].class));
        //List<Person> collect = responseEntities.stream().map(Person::new).collect(Collectors.toList());
        //log.info("Respuesta 1 de readPersons: {}", collect);

        List<Person> personList = Arrays.asList(restTemplate.getForObject(urlRead, Person[].class));
        log.info("Respuesta 2 de readPErsons: {}", personList);

        //PersonList personsList = restTemplate.getForObject(urlRead, PersonList.class);

        //HttpEntity request = new HttpEntity(new ArrayList<Person>());
        //ResponseEntity<PersonList> exchange = restTemplate.exchange(urlRead, HttpMethod.GET, request, PersonList.class);

    }

    public void readPerson(Integer id) {
        ResponseEntity<Person> readPersonResponse = restTemplate.getForEntity(url + "/read/"+id, Person.class);
        log.info("Respuesta de read person - ResponseEntity(Person): {}", readPersonResponse);

        Person personReaded = restTemplate.getForObject(url + "/read/"+id, Person.class);
        log.info("Respuesta read person - (Person): {}", personReaded);
    }

    public void updatePerson(Person person) {
        String urlUpdate = url + "/update";
        restTemplate.put(urlUpdate, person);
        log.info("Persona actualizada correctamente: {}", person);
    }

}
