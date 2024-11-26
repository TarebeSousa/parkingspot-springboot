package com.tarebe.parkingspot.controllers;

import com.tarebe.parkingspot.dtos.ParkingSpotDto;
import com.tarebe.parkingspot.models.ParkingSpotModel;
import com.tarebe.parkingspot.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService service;

    @PostMapping("/parking-spot")
    public ResponseEntity<ParkingSpotModel> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpot = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpot);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(parkingSpot));
    }

    @GetMapping("/parking-spot")
    public ResponseEntity<List<ParkingSpotModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
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
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
    }

    @PutMapping("/parking-spot/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ParkingSpotDto parkingSpotDto){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var parkingSpotModel = service.findById(id);
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        return ResponseEntity.status(HttpStatus.OK).body(service.update(parkingSpotModel));
    }

}