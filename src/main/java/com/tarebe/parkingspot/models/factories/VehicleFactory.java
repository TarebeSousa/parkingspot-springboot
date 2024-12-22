package com.tarebe.parkingspot.models.factories;
import com.tarebe.parkingspot.dtos.VehicleDto;
import com.tarebe.parkingspot.models.VehicleModel;
import com.tarebe.parkingspot.services.RiderService;
import com.tarebe.parkingspot.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    @Autowired
    private RiderService riderService;

    @Autowired
    VehicleService vehicleService;

    public VehicleModel convertToModel(VehicleDto vehicleDto, VehicleModel vehicleModel){
        vehicleModel.setVehicleType(vehicleDto.vehicleType());
        vehicleModel.setLiencePlate(vehicleDto.licensePlate());
        vehicleModel.setRider(riderService.findById(vehicleDto.riderId()));
        return vehicleModel;
    }
}