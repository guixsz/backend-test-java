package com.guilhermeSantana.backendtestjava.controller;

import com.guilhermeSantana.backendtestjava.domain.Establishment;
import com.guilhermeSantana.backendtestjava.dtos.EstablishmentDto;
import com.guilhermeSantana.backendtestjava.service.EstablishmentService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    private final EstablishmentService service;

    public EstablishmentController(EstablishmentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Establishment> CreateEstablishment(@Valid @RequestBody EstablishmentDto data){
        Establishment newEstablishment = service.createEstablishment(data);
        return new ResponseEntity<>(newEstablishment, HttpStatus.CREATED);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Establishment> FindEstablishmentByCnpj(@PathVariable() String cnpj) throws Exception {
        Establishment establishment = this.service.findEstablishmentByCnpj(cnpj);
        return ResponseEntity.ok().body(establishment);
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> findAll(){
        List<Establishment> listEstablishment = this.service.findAll();
        return new ResponseEntity<>(listEstablishment, HttpStatus.OK);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<Establishment> update(@PathVariable("cnpj") String cnpj, @RequestBody EstablishmentDto data) throws Exception{
            Establishment updateEstablishment = this.service.update(cnpj, data);
            return new ResponseEntity<>(updateEstablishment, HttpStatus.OK);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Establishment> delete(@PathVariable("cnpj") String cnpj) throws Exception{
        this.service.deleteEstablishment(cnpj);
        return  ResponseEntity.noContent().build();
    }
}
