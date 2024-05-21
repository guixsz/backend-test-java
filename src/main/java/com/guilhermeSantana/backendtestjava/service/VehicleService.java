package com.guilhermeSantana.backendtestjava.service;

import com.guilhermeSantana.backendtestjava.domain.Vehicle;
import com.guilhermeSantana.backendtestjava.dtos.VehicleDto;
import com.guilhermeSantana.backendtestjava.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository){
        this.repository = repository;
    }

    public Vehicle createVehicle(VehicleDto data){
        Vehicle newVehicle = new Vehicle(data);
        this.repository.save(newVehicle);
        return newVehicle;
    }

}
