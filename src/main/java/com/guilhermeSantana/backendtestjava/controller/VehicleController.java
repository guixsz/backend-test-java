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

}
