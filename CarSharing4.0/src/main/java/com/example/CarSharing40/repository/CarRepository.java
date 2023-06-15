package com.example.CarSharing40.repository;

import com.example.CarSharing40.module.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarRepository extends JpaRepository <Car, Long> {
}
