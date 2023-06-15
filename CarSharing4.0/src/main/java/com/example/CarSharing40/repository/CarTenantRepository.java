package com.example.CarSharing40.repository;

import com.example.CarSharing40.module.CarTenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTenantRepository extends JpaRepository<CarTenant, Long> {
}
