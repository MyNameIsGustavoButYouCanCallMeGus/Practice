package com.example.CarSharing40.controller;


import com.example.CarSharing40.dto.request.CarDtoRequest;
import com.example.CarSharing40.dto.response.CarDtoResponse;
import com.example.CarSharing40.mapper.CarMapper;
import com.example.CarSharing40.module.Car;
import com.example.CarSharing40.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/create")
    public ResponseEntity<CarDtoResponse> create(@RequestBody CarDtoRequest carDtoRequest) {
        Car car = carService.create(carDtoRequest);

        CarDtoResponse carDtoResponse = CarMapper.carDtoResponse(car);

        return new ResponseEntity<>(carDtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CarDtoResponse> update(@RequestBody CarDtoRequest carDtoRequest,
                                                 @PathVariable(name = "id") Long id) {
        Car car = carService.update(carDtoRequest, id);

        CarDtoResponse carDtoResponse = CarMapper.carDtoResponse(car);

        return new ResponseEntity<>(carDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        carService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
