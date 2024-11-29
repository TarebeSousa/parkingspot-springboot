package com.tarebe.parkingspot.dtos;


import jakarta.validation.constraints.NotBlank;

public record RiderDto(@NotBlank String name, @NotBlank String cnh) {
}
