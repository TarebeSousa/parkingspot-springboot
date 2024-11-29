package com.tarebe.parkingspot.services;

import com.tarebe.parkingspot.models.ParkingSpotModel;
import com.tarebe.parkingspot.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository repository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return repository.save(parkingSpotModel);
    }

    public List<ParkingSpotModel> getAll(){
        return repository.findAll();
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public ParkingSpotModel getOne(UUID id){
        Optional<ParkingSpotModel> parkingSpot = repository.findById(id);
        return parkingSpot.get();
    }

    public ParkingSpotModel update(ParkingSpotModel parkingSpotModel){
        return repository.save(parkingSpotModel);
    }


    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

    public ParkingSpotModel findById(UUID id) {
        Optional<ParkingSpotModel> obj = repository.findById(id);
        return obj.get();
    }


}
