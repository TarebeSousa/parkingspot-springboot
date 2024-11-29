package com.tarebe.parkingspot.repositories;

import com.tarebe.parkingspot.models.RiderModel;
import com.tarebe.parkingspot.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleModel, UUID> {


}
