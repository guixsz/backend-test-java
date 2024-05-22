package com.guilhermeSantana.backendtestjava.service;

import com.guilhermeSantana.backendtestjava.domain.EntryExit;
import com.guilhermeSantana.backendtestjava.domain.Establishment;
import com.guilhermeSantana.backendtestjava.domain.Vehicle;
import com.guilhermeSantana.backendtestjava.repositories.EntryExitRepository;
import com.guilhermeSantana.backendtestjava.repositories.EstablishmentRepository;
import com.guilhermeSantana.backendtestjava.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EntryExitService {

    private final EntryExitRepository entryExitRepository;

    private final VehicleRepository vehicleRepository;

    private final EstablishmentRepository establishmentRepository;

    public EntryExitService(EntryExitRepository entryExitRepository, VehicleRepository vehicleRepository, EstablishmentRepository establishmentRepository){
        this.entryExitRepository = entryExitRepository;
        this.vehicleRepository = vehicleRepository;
        this.establishmentRepository = establishmentRepository;
    }


    public EntryExit registerEntry(String plate, String cnpj) throws Exception{
        Vehicle vehicle = this.vehicleRepository.findByplate(plate).orElseThrow(() -> new Exception("Vehicle not found"));

        Establishment establishment = this.establishmentRepository.findEstablishmentByCnpj(cnpj).orElseThrow(() -> new Exception("Establishment not found"));

        EntryExit entryExit = new EntryExit();
        entryExit.setVehicle(vehicle);
        entryExit.setEstablishment(establishment);
        entryExit.setEntryDate(LocalDateTime.now());
        entryExit.setExitDate(LocalDateTime.now());

        entryExitRepository.save(entryExit);

        return entryExit;
    }

    public EntryExit registerExit(Integer id) throws Exception{
        EntryExit entryExit = this.entryExitRepository.findById(id).orElseThrow(() -> new Exception("Record not found"));

        entryExit.setExitDate(LocalDateTime.now());
        entryExitRepository.save(entryExit);

        return entryExit;
    }

}
