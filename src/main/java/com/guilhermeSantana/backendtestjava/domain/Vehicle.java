package com.guilhermeSantana.backendtestjava.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicles")
public class Vehicle {

    @Id
    private String plate;
    private String brand;
    private String color;
    private String model;
    private String type;

    public Vehicle() {
    }

    public Vehicle(String plate, String brand, String color, String model, String type) {
        this.plate = plate;
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
