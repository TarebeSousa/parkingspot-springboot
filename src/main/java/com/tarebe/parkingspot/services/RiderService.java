package com.tarebe.parkingspot.services;


import com.tarebe.parkingspot.models.RiderModel;
import com.tarebe.parkingspot.repositories.RiderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RiderService {

    @Autowired
    private RiderRepository repository;

    @Transactional
    public RiderModel save(RiderModel RiderModel) {
        return repository.save(RiderModel);
    }

    public List<RiderModel> getAll(){
        return repository.findAll();
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public RiderModel getOne(UUID id){
        Optional<RiderModel> rider = repository.findById(id);
        return rider.get();
    }

    public RiderModel update(RiderModel RiderModel){
        return repository.save(RiderModel);
    }


    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

    public RiderModel findById(UUID id) {
        Optional<RiderModel> obj = repository.findById(id);
        return obj.get();
    }


}
