package com.abi.resttemplate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonList {
    private List<Person> persons;

    public PersonList(List<Person> persons) {
        this.persons = new ArrayList<>();
    }
}
