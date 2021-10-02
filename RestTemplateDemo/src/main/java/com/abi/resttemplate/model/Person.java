package com.abi.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private int age;
    private double height;

    public Person(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.height = person.getHeight();
    }

    public Person(ResponseEntity<Person[]> responseEntity) {
    }
}
