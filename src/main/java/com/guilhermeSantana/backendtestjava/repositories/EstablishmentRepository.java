package com.guilhermeSantana.backendtestjava.repositories;

import com.guilhermeSantana.backendtestjava.domain.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, String> {
    Optional<Establishment> findEstablishmentByCnpj(String cnpj);
}
