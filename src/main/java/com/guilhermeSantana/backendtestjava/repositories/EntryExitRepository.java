package com.guilhermeSantana.backendtestjava.repositories;

import com.guilhermeSantana.backendtestjava.domain.EntryExit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntryExitRepository extends JpaRepository<EntryExit, Integer> {
}
