package com.example.CarSharing40.service;

import com.example.CarSharing40.dto.request.CarTenantDtoRequest;
import com.example.CarSharing40.exception.CustomExceptionMessage;
import com.example.CarSharing40.exception.custom.NotFoundException;
import com.example.CarSharing40.exception.custom.RepositoryCreateException;
import com.example.CarSharing40.exception.custom.RepositoryDeleteException;
import com.example.CarSharing40.module.Car;
import com.example.CarSharing40.module.CarTenant;
import com.example.CarSharing40.module.Tenant;
import com.example.CarSharing40.repository.CarTenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarTenantServiceImpl implements CarTenantService {

    private final CarTenantRepository carTenantRepository;

    private final CarService carService;

    private final TenantService tenantService;

    @Override
    public Optional<CarTenant> getById(Long id) {
        return carTenantRepository.findById(id);
    }

    @Override
    public CarTenant getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    private CarTenant save(CarTenant carTenant){
        return carTenantRepository.save(carTenant);
    }

    @Override
    public CarTenant create(CarTenantDtoRequest carUserDtoRequest) {
        CarTenant carTenant = new CarTenant();

        try {
            Car car = carService.getByIdThrowException(carUserDtoRequest.getCar_id());
            Tenant tenant = tenantService.getBYIdThrowException(carUserDtoRequest.getTenant_id());

            carTenant.setCar(car);
            carTenant.setTenant(tenant);

            return save(carTenant);
        } catch (Exception e) {
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void delete(Long id) {
        CarTenant carTenant = this.getByIdThrowException(id);

        try {
            carTenantRepository.delete(carTenant);
        } catch (Exception e) {
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }
}
