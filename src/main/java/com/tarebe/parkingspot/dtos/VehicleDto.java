package com.tarebe.parkingspot.dtos;


import com.tarebe.parkingspot.models.enums.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record VehicleDto(@NotNull VehicleType vehicleType,
                         @NotBlank @Size(max = 9, message = "License PLate must not have a maximum of 9 characters.") String licensePlate, @NotNull UUID riderId) {
}
