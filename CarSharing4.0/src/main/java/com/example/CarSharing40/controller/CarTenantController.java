package com.example.CarSharing40.controller;

import com.example.CarSharing40.dto.request.CarTenantDtoRequest;
import com.example.CarSharing40.dto.response.CarTenantDtoResponse;
import com.example.CarSharing40.mapper.CarTenantMapper;
import com.example.CarSharing40.module.CarTenant;
import com.example.CarSharing40.service.CarTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car-tenant")
@RequiredArgsConstructor
public class CarTenantController{

    private final CarTenantService carTenantService;

    @PostMapping("/create")
    public ResponseEntity<CarTenantDtoResponse> create(@RequestBody CarTenantDtoRequest carTenantDtoRequest){
        CarTenant carTenant = carTenantService.create(carTenantDtoRequest);

        CarTenantDtoResponse carTenantDtoResponse = CarTenantMapper.carTenantDtoResponse(carTenant);

        return new ResponseEntity<>(carTenantDtoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> create(@PathVariable(name = "id") Long id){

        carTenantService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
