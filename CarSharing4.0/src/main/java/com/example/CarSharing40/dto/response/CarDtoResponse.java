package com.example.CarSharing40.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDtoResponse {
    private Long id;

    private String model;

    private String type;

    private Long price;
}
