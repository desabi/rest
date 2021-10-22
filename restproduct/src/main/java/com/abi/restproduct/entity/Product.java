package com.abi.restproduct.entity;

import com.abi.restproduct.model.ProductRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.PublicKey;

@Entity
@Data
@NoArgsConstructor // para create
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;

    // para create y update
    // asignar el objeto dto a objeto entity
    public Product(ProductRequest productRequest){
        this.id = productRequest.getId();
        this.name = productRequest.getName();
        this.description = productRequest.getDescription();
        this.price = productRequest.getPrice();
        this.quantity = productRequest.getQuantity();
    }
}
