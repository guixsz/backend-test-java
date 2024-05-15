package com.guilhermeSantana.backendtestjava.service;

import com.guilhermeSantana.backendtestjava.domain.Establishment;
import com.guilhermeSantana.backendtestjava.dtos.EstablishmentDto;
import com.guilhermeSantana.backendtestjava.repositories.EstablishmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {

    private final EstablishmentRepository repository;

    public EstablishmentService(EstablishmentRepository repository){
        this.repository = repository;
    }

    public void save(Establishment establishment) {
        this.repository.save(establishment);
    }
    public Establishment createEstablishment(EstablishmentDto data){
        Establishment newEstablishment = new Establishment(data);
        return newEstablishment;
    }

}
