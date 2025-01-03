package com.tarebe.parkingspot.controllers;


import com.tarebe.parkingspot.dtos.VehicleDto;
import com.tarebe.parkingspot.models.RiderModel;
import com.tarebe.parkingspot.models.VehicleModel;
import com.tarebe.parkingspot.models.factories.RiderFactory;
import com.tarebe.parkingspot.models.factories.VehicleFactory;
import com.tarebe.parkingspot.services.RiderService;
import com.tarebe.parkingspot.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @Autowired
    private VehicleFactory vehicleFactory;

    @Autowired
    RiderService riderService;

    @PostMapping("/vehicle")
    public ResponseEntity<Object> saveVehicle(@RequestBody @Valid VehicleDto vehicleDto) {
        if (!riderService.existsById(vehicleDto.riderId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rider ID is invalid or not found.");
        }
        var vehicle = new VehicleModel();
        vehicleFactory.convertToModel(vehicleDto, vehicle);
        var savedVehicle = service.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }


    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleModel>> getAll(){
        List<VehicleModel> vehicleList = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(vehicleList);
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") UUID id){

        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Vehicle deleted successfully");
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value="id") UUID id){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
        }
        var vehicle = service.getOne(id) ;
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<Object> update(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid VehicleDto vehicleDto){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
        }
        var vehicleModel = service.findById(id);
        vehicleFactory.convertToModel(vehicleDto, vehicleModel);
        var updatedVehicle = service.update(vehicleModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedVehicle);
    }

}