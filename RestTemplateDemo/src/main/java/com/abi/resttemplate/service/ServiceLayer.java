package com.abi.resttemplate.service;

import com.abi.resttemplate.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {

    private static final Logger log = LoggerFactory.getLogger(ServiceLayer.class);

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8090/person";

    public void home() throws JsonProcessingException {
        ResponseEntity<String> homeResponse = restTemplate.getForEntity(url, String.class);
        log.info("Respuesta de persona home: {}", homeResponse);

        // obtener mensaje devuelto por el endpoint
        //ObjectMapper mapper = new ObjectMapper();
        //JsonNode jsonNode = mapper.readTree(homeResponse.getBody());
        //JsonNode message = jsonNode.path("name");
        //log.info("Mensaje: {}", message);
    }

    public void readPerson(Integer id) {
        ResponseEntity<Person> readPersonResponse = restTemplate.getForEntity(url + "/read/"+id, Person.class);
        log.info("Respuesta de read person: {}", readPersonResponse);

        Person personReaded = restTemplate.getForObject(url + "/read/"+id, Person.class);
        log.info("Respuesta person readed: {}", personReaded);
    }

    public void createPerson(Person person){
        HttpEntity<Person> request = new HttpEntity<>(person);
        String urlCreate = url + "/create";
        restTemplate.postForObject(urlCreate, request, Person.class);
    }
}
