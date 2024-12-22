package com.tarebe.parkingspot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tarebe.parkingspot.models.enums.VehicleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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

    @ManyToOne
    @JoinColumn(name = "rider_id")
    @JsonIgnoreProperties("vehicles")
    private RiderModel rider;

    public VehicleModel(UUID id, VehicleType vehicleType, String liencePlate, RiderModel rider) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.liencePlate = liencePlate;
        this.rider = rider;
    }

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

    public RiderModel getRider() {
        return rider;
    }

    public void setRider(RiderModel rider) {
        this.rider = rider;
    }
}
