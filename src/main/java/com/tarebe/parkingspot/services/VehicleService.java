package com.tarebe.parkingspot.services;


import com.tarebe.parkingspot.models.VehicleModel;
import com.tarebe.parkingspot.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Transactional
    public VehicleModel save(VehicleModel vehicleModel) {
        return repository.save(vehicleModel);
    }

    public List<VehicleModel> getAll(){
        return repository.findAll();
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public VehicleModel getOne(UUID id){
        Optional<VehicleModel> vehicle = repository.findById(id);
        return vehicle.get();
    }

    public VehicleModel update(VehicleModel VehicleModel){
        return repository.save(VehicleModel);
    }

    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

    public VehicleModel findById(UUID id) {
        Optional<VehicleModel> obj = repository.findById(id);
        return obj.get();
    }

}
