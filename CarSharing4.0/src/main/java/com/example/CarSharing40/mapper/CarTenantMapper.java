package com.example.CarSharing40.mapper;

import com.example.CarSharing40.dto.response.CarTenantDtoResponse;
import com.example.CarSharing40.module.CarTenant;

public class CarTenantMapper {
    public static CarTenantDtoResponse carTenantDtoResponse(CarTenant carTenant){
        CarTenantDtoResponse carTenantDtoResponse = new CarTenantDtoResponse();

        carTenantDtoResponse.setId(carTenant.getId());
        carTenantDtoResponse.setCarDtoResponse(CarMapper.carDtoResponse(carTenant.getCar()));
        carTenantDtoResponse.setTenantDtoResponse(TenantMapper.tenantDtoResponse(carTenant.getTenant()));

        return carTenantDtoResponse;
    }
}
