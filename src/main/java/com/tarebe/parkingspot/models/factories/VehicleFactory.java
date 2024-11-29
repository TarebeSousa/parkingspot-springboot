package com.tarebe.parkingspot.models.factories;


import com.tarebe.parkingspot.dtos.VehicleDto;
import com.tarebe.parkingspot.models.VehicleModel;

public class VehicleFactory {

    public static VehicleModel convertToModel(VehicleDto vehicleDto, VehicleModel vehicleModel){
        vehicleModel.setVehicleType(vehicleDto.vehicleType());
        vehicleModel.setLiencePlate(vehicleDto.licensePlate());
        return vehicleModel;
    }
}
