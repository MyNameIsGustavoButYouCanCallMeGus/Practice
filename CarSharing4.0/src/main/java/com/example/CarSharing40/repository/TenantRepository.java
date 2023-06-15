package com.example.CarSharing40.repository;

import com.example.CarSharing40.module.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
