package com.example.CarSharing40.service;


import com.example.CarSharing40.dto.request.CarDtoRequest;
import com.example.CarSharing40.exception.CustomExceptionMessage;
import com.example.CarSharing40.exception.custom.NotFoundException;
import com.example.CarSharing40.exception.custom.RepositoryCreateException;
import com.example.CarSharing40.exception.custom.RepositoryDeleteException;
import com.example.CarSharing40.exception.custom.RepositoryUpdateException;
import com.example.CarSharing40.module.Car;
import com.example.CarSharing40.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public Car create(CarDtoRequest carDtoRequest) {
        Car car = new Car();

        try {
            car.setModel(carDtoRequest.getModel());
            car.setType(carDtoRequest.getType());
            car.setPrice(carDtoRequest.getPrice());

            return this.saveCar(car);
        } catch (Exception e){
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public Car update(CarDtoRequest carDtoRequest, Long id) {
        Car car = this.getByIdThrowException(id);

        try {
            car.setModel(carDtoRequest.getModel());
            car.setType(carDtoRequest.getType());
            car.setPrice(carDtoRequest.getPrice());

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
        return this.saveCar(car);

    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Car car = this.getByIdThrowException(id);

        try {
            carRepository.delete(car);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }

    }
}
