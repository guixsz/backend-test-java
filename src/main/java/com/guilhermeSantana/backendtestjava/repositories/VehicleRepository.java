package com.guilhermeSantana.backendtestjava.repositories;

import com.guilhermeSantana.backendtestjava.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Optional<Vehicle> findByplate(String plate);
}
