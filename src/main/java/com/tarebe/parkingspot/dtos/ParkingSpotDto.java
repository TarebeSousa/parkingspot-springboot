package com.tarebe.parkingspot.dtos;

import com.tarebe.parkingspot.models.enums.ParkingSpotStatus;
import com.tarebe.parkingspot.models.enums.ParkingSpotType;
import jakarta.validation.constraints.NotNull;


public record ParkingSpotDto(@NotNull ParkingSpotStatus status, @NotNull ParkingSpotType type) {

}
