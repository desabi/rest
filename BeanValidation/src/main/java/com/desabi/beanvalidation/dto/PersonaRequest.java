package com.desabi.beanvalidation.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class PersonaRequest {

    @NotNull(message = "{persona.nombre.nulo}")
    @Size(
            min = 3,
            max = 15,
            message = "El nombre debe tener entre {min} y {max} caracteres."
    )
    private String nombre;

    @Min(value = 18, message = "{persona.edad.min}")
    @Max(value = 100, message = "{persona.edad.max}")
    private int edad;

    @Positive(message = "La estatura '${validatedValue}' no es valida")
    private double estatura;

    @NotNull
    private Long telefono;

    @Email(message = "{persona.correo.email}")
    @NotNull(message = "{persona.correo.null}")
    @NotBlank(message = "{persona.correo.blank}")
    private String correo;

    @NotNull(message = "{persona.numeros.null}")
    @NotEmpty(message = "{persona.numeros.empty}")
    private List<@Positive(message = "{persona.numeros.positivo}") Integer> numeros;
}