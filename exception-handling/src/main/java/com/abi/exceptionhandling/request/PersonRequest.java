package com.abi.exceptionhandling.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class PersonRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Integer age;

    @NotNull
    @Positive
    private Double weight;

}
