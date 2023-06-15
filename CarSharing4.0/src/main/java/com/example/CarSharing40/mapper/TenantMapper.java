package com.example.CarSharing40.mapper;

import com.example.CarSharing40.dto.response.TenantDtoResponse;
import com.example.CarSharing40.module.Tenant;

public class TenantMapper {
    public static TenantDtoResponse tenantDtoResponse(Tenant tenant){

        TenantDtoResponse tenantDtoResponse = new TenantDtoResponse();
        tenantDtoResponse.setId(tenant.getId());
        tenantDtoResponse.setUsername(tenant.getUsername());
        tenantDtoResponse.setName(tenant.getName());
        tenantDtoResponse.setSurname(tenant.getSurname());
        tenantDtoResponse.setAge(tenant.getAge());

        return tenantDtoResponse;
    }
}
