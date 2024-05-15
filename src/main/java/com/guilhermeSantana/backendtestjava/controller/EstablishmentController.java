package com.guilhermeSantana.backendtestjava.controller;

import com.guilhermeSantana.backendtestjava.domain.Establishment;
import com.guilhermeSantana.backendtestjava.dtos.EstablishmentDto;
import com.guilhermeSantana.backendtestjava.service.EstablishmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Establishment> FindEstablishmentByCnpj(@PathVariable String cnpj) throws Exception {
        Establishment establishment = this.service.findEstablishmentByCnpj(cnpj);
        return ResponseEntity.ok().body(establishment);
    }
}
