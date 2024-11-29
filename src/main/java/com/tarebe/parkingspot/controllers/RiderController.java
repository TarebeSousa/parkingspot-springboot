package com.tarebe.parkingspot.controllers;


import com.tarebe.parkingspot.dtos.RiderDto;
import com.tarebe.parkingspot.models.RiderModel;
import com.tarebe.parkingspot.models.factories.RiderFactory;
import com.tarebe.parkingspot.services.RiderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class RiderController {

    @Autowired
    private RiderService service;

    @PostMapping("/rider")
    public ResponseEntity<RiderModel> saveRider(@RequestBody @Valid RiderDto RiderDto){
        var rider = new RiderModel();
        RiderFactory.convertToModel(RiderDto, rider);
        var savedRider = service.save(rider);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRider);
    }

    @GetMapping("/rider")
    public ResponseEntity<List<RiderModel>> getAll(){
        List<RiderModel> RiderList = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(RiderList);
    }

    @DeleteMapping("/rider/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") UUID id){

        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rider not found");
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Rider deleted successfully");
    }

    @GetMapping("/rider/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value="id") UUID id){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rider not found.");
        }
        var Rider = service.getOne(id) ;
        return ResponseEntity.status(HttpStatus.OK).body(Rider);
    }

    @PutMapping("/rider/{id}")
    public ResponseEntity<Object> update(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid RiderDto RiderDto){
        if(!service.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rider not found.");
        }
        var RiderModel = service.findById(id);
        RiderFactory.convertToModel(RiderDto, RiderModel);
        var updatedRider = service.update(RiderModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRider);
    }

}