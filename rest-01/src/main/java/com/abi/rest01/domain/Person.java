package com.abi.rest01.domain;

import com.abi.rest01.dto.PersonDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private double height;

    public Person(PersonDTO personDTO){
        this.id = personDTO.getId();
        this.name = personDTO.getName();
        this.age = personDTO.getAge();
        this.height = personDTO.getHeight();
    }
}
