package com.example.CarSharing40.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CarTenantDtoRequest {

    @NotBlank(message = "Car must be specified.")
    private Long car_id;

    @NotBlank(message = "Tenant must be specified")
    private Long tenant_id;
}
