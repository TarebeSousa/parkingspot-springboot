package com.tarebe.parkingspot.models.factories;

import com.tarebe.parkingspot.dtos.ParkingSpotDto;
import com.tarebe.parkingspot.models.ParkingSpotModel;

import java.util.UUID;

public class ParkingSpotFactory {

    public static ParkingSpotModel convertToModel(ParkingSpotDto parkingSpotDto, ParkingSpotModel parkingSpotModel){
        parkingSpotModel.setStatus(parkingSpotDto.status());
        parkingSpotModel.setType(parkingSpotDto.type());
        return parkingSpotModel;
    }
}
