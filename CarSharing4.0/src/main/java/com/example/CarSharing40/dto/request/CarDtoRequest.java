package com.example.CarSharing40.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CarDtoRequest {

    @NotBlank(message = "Model must be specified")
    private String model;

    @NotBlank(message = "Type must be specified")
    private String type;

    @NotBlank(message = "Price must be specified")
    private Long price;
}
