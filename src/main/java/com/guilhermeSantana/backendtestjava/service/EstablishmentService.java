package com.guilhermeSantana.backendtestjava.service;

import com.guilhermeSantana.backendtestjava.domain.Establishment;
import com.guilhermeSantana.backendtestjava.dtos.EstablishmentDto;
import com.guilhermeSantana.backendtestjava.repositories.EstablishmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        this.save(newEstablishment);
        return newEstablishment;
    }
    public Establishment findEstablishmentByCnpj(String cnpj) throws  Exception{
        return this.repository.findEstablishmentByCnpj(cnpj).orElseThrow(() -> new Exception("Estabelecimento não encontrado"));
    }

    public void deleteEstablishment(String cnpj) throws Exception{
        Establishment establishment = findEstablishmentByCnpj(cnpj);
        this.repository.delete(establishment);
    }

    public List<Establishment> findAll(){
        return this.repository.findAll();
    }

    public Establishment update(String cnpj, EstablishmentDto data) throws Exception{
        Establishment establishment = this.findEstablishmentByCnpj(cnpj);
        deleteEstablishment(establishment.getCnpj());

        Establishment newestablishment = new Establishment(data);
        repository.save(newestablishment);

        return newestablishment;

    }
}
