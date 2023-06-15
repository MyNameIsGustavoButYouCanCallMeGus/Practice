package com.example.CarSharing40.service;

import com.example.CarSharing40.dto.request.CarTenantDtoRequest;
import com.example.CarSharing40.module.CarTenant;

import java.util.Optional;

public interface CarTenantService {

    Optional<CarTenant> getById(Long id);

    CarTenant getByIdThrowException(Long id);

    CarTenant create(CarTenantDtoRequest carTenantDtoRequest);

    void delete(Long id);
}
