package com.guilhermeSantana.backendtestjava.domain;

import com.guilhermeSantana.backendtestjava.dtos.EstablishmentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "establishments")
public class Establishment {

    @Id
    private String cnpj;
    private String name;
    private String address;
    private String phone;
    private Integer numberMoto;
    private Integer numberCar;

    public Establishment() {
    }

    public Establishment(String cnpj, String name, String address, String phone, Integer numberMoto, Integer numberCar) {
        this.cnpj = cnpj;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.numberMoto = numberMoto;
        this.numberCar = numberCar;
    }

    public Establishment(EstablishmentDto data){
        this.cnpj = data.cnpj();
        this.name = data.name();
        this.address = data.address();
        this.phone = data.phone();
        this.numberMoto = data.numberMoto();
        this.numberCar = data.numberCar();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNumberMoto() {
        return numberMoto;
    }

    public void setNumberMoto(Integer numberMoto) {
        this.numberMoto = numberMoto;
    }

    public Integer getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(Integer numberCar) {
        this.numberCar = numberCar;
    }
}
