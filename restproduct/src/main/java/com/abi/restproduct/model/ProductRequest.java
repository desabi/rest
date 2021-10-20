package com.abi.restproduct.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {

    private Integer id;

    @NotNull(message = "El nombre no puede quedar vacío")
    @NotBlank(message = "El nombre no puede quedar en blanco")
    private String name;

    @NotNull(message = "La descripción no puede quedar vacía")
    @NotBlank(message = "La descripcion no puede quedar en blanco")
    private String description;

    @NotNull(message = "El precio no puede quedar vacío")
    @Positive(message = "El precio debe ser positivo")
    private Double price;

    @NotNull(message = "La cantidad no puede quedar vacía")
    @Positive(message = "La cantidad debe ser positiva")
    private Integer quantity;
}
