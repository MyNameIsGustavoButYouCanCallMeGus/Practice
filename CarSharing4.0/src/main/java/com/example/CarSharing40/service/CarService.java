package com.example.CarSharing40.service;



import com.example.CarSharing40.dto.request.CarDtoRequest;
import com.example.CarSharing40.module.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> getById(Long id);

    Car getByIdThrowException(Long id);

    Car create(CarDtoRequest carDtoRequest);

    Car update(CarDtoRequest carDtoRequest, Long id);

    List<Car> getAll();

    void delete(Long id);

}
