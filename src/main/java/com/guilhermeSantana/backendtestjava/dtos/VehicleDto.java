package com.guilhermeSantana.backendtestjava.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleDto(@NotBlank String plate, @NotBlank String brand, @NotBlank String model, @NotBlank String color) {
}
