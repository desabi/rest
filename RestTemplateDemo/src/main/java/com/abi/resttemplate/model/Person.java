package com.abi.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
