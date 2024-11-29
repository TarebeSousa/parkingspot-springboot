package com.tarebe.parkingspot.repositories;

import com.tarebe.parkingspot.models.RiderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RiderRepository extends JpaRepository<RiderModel, UUID> {


}
