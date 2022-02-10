package com.abi.restproduct.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {

    private Integer id;

    @NotNull(message = "{product.name.notnull}")
    @NotBlank(message = "{product.name.notblank}")
    private String name;

    @NotNull(message = "La descripción no puede quedar vacía")
    @NotBlank(message = "La descripcion no puede quedar en blanco")
    private String description;

    @NotNull(message = "{product.price.notnull}")
    @Positive(message = "{product.price.positive}")
    private Double price;

    @NotNull(message = "La cantidad no puede quedar vacía")
    @Positive(message = "La cantidad debe ser positiva")
    private Integer quantity;

    public ProductRequest(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
