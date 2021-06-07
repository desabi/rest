package com.desabi.beanvalidation.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProductoRequest {

    @NotNull(message = "{producto.nombre.nulo}")
    @NotBlank(message = "{producto.nombre.blanco}")
    private String nombre;

    private double precio;

    @Min(value = 1, message = "{producto.cantidad.min}")
    @Max(value = 10, message = "{producto.cantidad.max}")
    @Positive(message = "{producto.cantidad.negativo}")
    private int cantidad;

}
