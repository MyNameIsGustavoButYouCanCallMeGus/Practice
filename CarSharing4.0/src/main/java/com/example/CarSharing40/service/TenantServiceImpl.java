package com.example.CarSharing40.service;

import com.example.CarSharing40.dto.request.TenantDtoRequest;
import com.example.CarSharing40.exception.CustomExceptionMessage;
import com.example.CarSharing40.exception.custom.*;
import com.example.CarSharing40.module.Tenant;
import com.example.CarSharing40.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService{

    private final TenantRepository tenantRepository;

    private final String AGE_EXCEPTION = "Tenant's age must be over than 18";

    private Tenant save(Tenant tenant){
        return tenantRepository.save(tenant);
    }

    @Override
    public Optional<Tenant> getById(Long id) {
        return tenantRepository.findById(id);
    }

    @Override
    public Tenant getBYIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public Tenant create(TenantDtoRequest tenantDtoRequest) {
        Tenant tenant = new Tenant();

        try {
            tenant.setUsername(tenantDtoRequest.getUsername());
            tenant.setName(tenantDtoRequest.getName());
            tenant.setSurname(tenantDtoRequest.getSurname());
            tenant.setAge(tenantDtoRequest.getAge());
            if (tenantDtoRequest.getAge() < 18) throw new AgeException(this.AGE_EXCEPTION);

            return this.save(tenant);
        } catch (Exception e){
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public Tenant update(TenantDtoRequest tenantDtoRequest, Long id) {
        Tenant tenant = this.getBYIdThrowException(id);

        try {
            tenant.setUsername(tenantDtoRequest.getUsername());
            tenant.setName(tenantDtoRequest.getName());
            tenant.setSurname(tenantDtoRequest.getSurname());
            tenant.setAge(tenantDtoRequest.getAge());

            return this.save(tenant);
        } catch (Exception e){
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void delete(Long id) {
        Tenant tenant = this.getBYIdThrowException(id);

        try {
            tenantRepository.delete(tenant);
        } catch (Exception e){
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }
}
