package com.tarebe.parkingspot.config;

import com.tarebe.parkingspot.models.ParkingSpotModel;
import com.tarebe.parkingspot.models.RiderModel;
import com.tarebe.parkingspot.models.VehicleModel;
import com.tarebe.parkingspot.models.enums.ParkingSpotStatus;
import com.tarebe.parkingspot.models.enums.ParkingSpotType;
import com.tarebe.parkingspot.models.enums.VehicleType;
import com.tarebe.parkingspot.repositories.ParkingSpotRepository;
import com.tarebe.parkingspot.repositories.RiderRepository;
import com.tarebe.parkingspot.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void run(String... args) throws Exception {
        ParkingSpotModel parkingSpotModel0 = new ParkingSpotModel(null, ParkingSpotStatus.OCCUPIED, ParkingSpotType.MOTORCYCLE);
        ParkingSpotModel parkingSpotModel1 = new ParkingSpotModel(null, ParkingSpotStatus.FREE, ParkingSpotType.CAR);
        ParkingSpotModel parkingSpotModel2 = new ParkingSpotModel(null, ParkingSpotStatus.OCCUPIED, ParkingSpotType.TRUCK);

        RiderModel riderModel0 = new RiderModel(null, "João Claudio", "123456789");
        RiderModel riderModel1 = new RiderModel(null, "Maria Josefa", "125489657");
        RiderModel riderModel2 = new RiderModel(null, "Luana Melo", "324578950");

        VehicleModel vehicleModel0 = new VehicleModel(null, VehicleType.TRUCK, "WBX-325", riderModel0);
        VehicleModel vehicleModel1 = new VehicleModel(null, VehicleType.CAR, "CQC-745", riderModel1);
        VehicleModel vehicleModel2 = new VehicleModel(null, VehicleType.MOTORCYCLE, "TAR-224", riderModel1);

        riderRepository.save(riderModel0);
        vehicleModel0.setRider(riderModel0);
        riderModel0.setParkingSpot(parkingSpotModel0);
        riderModel0.getVehicles().add(vehicleModel0);
        parkingSpotModel0.setRider(riderModel0);



        parkingSpotRepository.save(parkingSpotModel0);
        parkingSpotRepository.save(parkingSpotModel1);
        parkingSpotRepository.save(parkingSpotModel2);


    }
}
