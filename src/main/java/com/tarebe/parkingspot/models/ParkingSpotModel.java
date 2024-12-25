package com.tarebe.parkingspot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tarebe.parkingspot.models.enums.ParkingSpotStatus;
import com.tarebe.parkingspot.models.enums.ParkingSpotType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_parking_spot")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private ParkingSpotStatus status;
    private ParkingSpotType type;

    @OneToOne
    @JoinColumn(name = "rider_parkingspot_id")
    @JsonIgnoreProperties("parkingSpot")
    private RiderModel rider;

    public ParkingSpotModel() {
    }

    public ParkingSpotModel(UUID id, ParkingSpotStatus status, ParkingSpotType type) {
        this.id = id;
        this.status = status;
        this.type = type;
    }

    public ParkingSpotModel(ParkingSpotStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ParkingSpotStatus getStatus() {
        return this.status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    public RiderModel getRider() {
        return rider;
    }

    public void setRider(RiderModel rider) {
        this.rider = rider;
    }
}
