package com.abi.rest01.repository;

import com.abi.rest01.domain.Person;

import java.util.List;

public interface PersonRepository {
    public List<Person> read();
}
