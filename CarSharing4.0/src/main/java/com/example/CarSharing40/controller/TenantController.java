package com.example.CarSharing40.controller;

import com.example.CarSharing40.dto.request.TenantDtoRequest;
import com.example.CarSharing40.dto.response.TenantDtoResponse;
import com.example.CarSharing40.mapper.TenantMapper;
import com.example.CarSharing40.module.Tenant;
import com.example.CarSharing40.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tenant")
@RequiredArgsConstructor
public class TenantController{

    private final TenantService tenantService;

    @PostMapping("/create")
    public ResponseEntity<TenantDtoResponse> create(@RequestBody TenantDtoRequest tenantDtoRequest){
        Tenant tenant = tenantService.create(tenantDtoRequest);

        TenantDtoResponse tenantDtoResponse = TenantMapper.tenantDtoResponse(tenant);

        return new ResponseEntity<>(tenantDtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TenantDtoResponse> update(@RequestBody TenantDtoRequest tenantDtoRequest,
                                                    @PathVariable(name = "id") Long id){
        Tenant tenant = tenantService.update(tenantDtoRequest, id);

        TenantDtoResponse tenantDtoResponse = TenantMapper.tenantDtoResponse(tenant);

        return new ResponseEntity<>(tenantDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id){

        tenantService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
