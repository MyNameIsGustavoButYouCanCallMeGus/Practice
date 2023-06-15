package com.example.CarSharing40.service;

import com.example.CarSharing40.dto.request.TenantDtoRequest;
import com.example.CarSharing40.module.Tenant;

import java.util.Optional;

public interface TenantService {

    Optional<Tenant> getById(Long id);

    Tenant getBYIdThrowException(Long id);

    Tenant create(TenantDtoRequest tenantDtoRequest);

    Tenant update(TenantDtoRequest tenantDtoRequest, Long id);

    void delete(Long id);

}
