package com.example.CarSharing40.mapper;


import com.example.CarSharing40.dto.response.CarDtoResponse;
import com.example.CarSharing40.module.Car;

public class CarMapper {

    public static CarDtoResponse carDtoResponse(Car car) {
        CarDtoResponse carDtoResponse = new CarDtoResponse();

        carDtoResponse.setId(car.getId());
        carDtoResponse.setModel(car.getModel());
        carDtoResponse.setType(car.getType());
        carDtoResponse.setPrice(car.getPrice());

        return carDtoResponse;
    }
}
