package com.tarebe.parkingspot.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RiderDto(@NotBlank String name,
                       @Size(max = 11, message = "CNH must not have a maximum of 11 characters.") String cnh) {
}
