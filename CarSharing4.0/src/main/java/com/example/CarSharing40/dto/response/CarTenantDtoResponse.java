package com.example.CarSharing40.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class CarTenantDtoResponse {
    private Long id;

    private CarDtoResponse carDtoResponse;

    private TenantDtoResponse tenantDtoResponse;

    private LocalTime localTime;
}
