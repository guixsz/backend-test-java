package com.guilhermeSantana.backendtestjava.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstablishmentDto(@NotNull String cnpj, @NotBlank String name, @NotBlank String address, @NotBlank String phone, @NotNull Integer numberMoto, @NotNull Integer numberCar) {
}
