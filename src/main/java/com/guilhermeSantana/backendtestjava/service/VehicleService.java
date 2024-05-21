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

    public Vehicle findByPlate(String plate) throws Exception{
        return this.repository.findByplate(plate).orElseThrow(() -> new Exception("Veiculo não encontrado"));
    }

    public Vehicle createVehicle(VehicleDto data){
        Vehicle newVehicle = new Vehicle(data);
        this.repository.save(newVehicle);
        return newVehicle;
    }

    public List<Vehicle> findAll(){
        return this.repository.findAll();
    }

    public void deleteVehicle(String plate) throws Exception{
        Vehicle vehicle = findByPlate(plate);
        this.repository.deleteById(plate);
    }

    public Vehicle update(String plate, VehicleDto data) throws Exception{
        Vehicle updateVehicle = findByPlate(plate);
        deleteVehicle(updateVehicle.getPlate());

        Vehicle newVehicle = new Vehicle(data);
        repository.save(newVehicle);

        return newVehicle;
    }
}
