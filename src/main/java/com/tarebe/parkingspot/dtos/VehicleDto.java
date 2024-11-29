package com.tarebe.parkingspot.dtos;


import com.tarebe.parkingspot.models.enums.VehicleType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VehicleDto(@NotNull VehicleType vehicleType,
                         @Size(max = 9, message = "License PLate must not have a maximum of 9 characters.") String licensePlate) {
}
