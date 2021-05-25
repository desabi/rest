package com.abi.rest01.dto;

import com.abi.rest01.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

    private int id;

    @NotNull(message = "El nombre no puede quedar vacio")
    @Size(min = 3, max = 20, message = "Longitud del nombre: de 3 a 20 caracteres.")
    private String name;

    @Positive(message = "La edad debe ser un numero positivo.")
    @Min(value = 18, message = "Edad mínima: 18")
    @Max(value = 100, message = "Edad máxima: 100")
    private int age;

    @NotNull(message = "La estatura no puede quedar vacia")
    @Positive(message = "La estatura debe ser un numero positivo.")
    private double height;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.height = person.getHeight();
    }
}
