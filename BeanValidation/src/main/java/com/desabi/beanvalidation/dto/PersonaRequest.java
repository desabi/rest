package com.desabi.beanvalidation.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PersonaRequest {

    @NotNull(message = "{persona.nombre.nulo}")
    @Size(min = 3, max = 15, message = "{persona.nombre.size}")
    private String nombre;

    @Min(value = 18, message = "{persona.edad.min}")
    @Max(value = 100, message = "{persona.edad.max}")
    private int edad;

    @Positive
    private double estatura;

    @NotNull
    private Long telefono;

    @Email
    private String correo;
}