package com.abi.exceptionhandling.repository;

import com.abi.exceptionhandling.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // en la capa service utilizar las excepciones personalizadas
}
