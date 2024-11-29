package com.tarebe.parkingspot.models;

import com.tarebe.parkingspot.models.enums.VehicleType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_vehicle")
public class VehicleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    VehicleType vehicleType;
    String liencePlate;

    public VehicleModel(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLiencePlate() {
        return liencePlate;
    }

    public void setLiencePlate(String liencePlate) {
        this.liencePlate = liencePlate;
    }
}
