package com.guilhermeSantana.backendtestjava.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entry_exit")
public class EntryExit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "establishment_cnpj")
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "vehicle_plate")
    private Vehicle vehicle;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "exit_date")
    private LocalDateTime exitDate;

    public EntryExit() {
    }

    public EntryExit(Integer id, Establishment establishment, Vehicle vehicle, LocalDateTime entryDate, LocalDateTime exitDate) {
        this.id = id;
        this.establishment = establishment;
        this.vehicle = vehicle;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }
}
