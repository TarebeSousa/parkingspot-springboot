package com.tarebe.parkingspot.controllers;

import com.tarebe.parkingspot.dtos.ParkingSpotDto;
import com.tarebe.parkingspot.models.ParkingSpotModel;
import com.tarebe.parkingspot.models.factories.ParkingSpotFactory;
import com.tarebe.parkingspot.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService service;

    @PostMapping("/parking-spot")
    public ResponseEntity<ParkingSpotModel> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpot = new ParkingSpotModel();
        ParkingSpotFactory.convertToModel(parkingSpotDto, parkingSpot);
        var savedParkingSpot = service.save(parkingSpot);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedParkingSpot);
    }

    @GetMapping("/parking-spot")
    public ResponseEntity<List<ParkingSpotModel>> getAll(){
        List<ParkingSpotModel> parkingSpotList = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotList);
    }

    @DeleteMapping("/parking-spot/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") UUID id){

        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @GetMapping("/parking-spot/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value="id") UUID id){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var parkingSpot = service.getOne(id) ;
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpot);
    }

    @PutMapping("/parking-spot/{id}")
    public ResponseEntity<Object> update(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ParkingSpotDto parkingSpotDto){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var parkingSpotModel = service.findById(id);
        ParkingSpotFactory.convertToModel(parkingSpotDto, parkingSpotModel);
        var updatedParkingSpot = service.update(parkingSpotModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedParkingSpot);
    }

}