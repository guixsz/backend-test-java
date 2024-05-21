package com.guilhermeSantana.backendtestjava.controller;

import com.guilhermeSantana.backendtestjava.domain.Vehicle;
import com.guilhermeSantana.backendtestjava.dtos.VehicleDto;
import com.guilhermeSantana.backendtestjava.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody VehicleDto data){
        Vehicle newVehicle = this.service.createVehicle(data);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAll(){
        List<Vehicle> vehicleList = this.service.findAll();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<Vehicle> findByPlate(@PathVariable("plate") String plate) throws Exception{
        Vehicle vehicle = service.findByPlate(plate);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity<Vehicle> delete(@PathVariable("plate") String plate) throws Exception{
        service.deleteVehicle(plate);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{plate}")
    public ResponseEntity<Vehicle> update(@PathVariable("plate") String plate, @RequestBody VehicleDto data) throws Exception{
        Vehicle updateVehicle = this.service.update(plate, data);
        return  new ResponseEntity<>(updateVehicle, HttpStatus.CREATED);
    }
}
