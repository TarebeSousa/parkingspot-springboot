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
        // Criar ParkingSpot
        ParkingSpotModel ps = new ParkingSpotModel(null, ParkingSpotStatus.FREE, ParkingSpotType.CAR);
        parkingSpotRepository.save(ps);

        // Criar veículo
        VehicleModel vm = new VehicleModel(null, VehicleType.TRUCK, "123456789");

        // Criar rider e associar veículo
        RiderModel rm = new RiderModel(null, "Marcos Oliveira", "01245879621");
        rm.getVehicles().add(vm);
        vm.setRider(rm);

        // Salvar rider (Cascade.ALL salva o veículo automaticamente)
        riderRepository.save(rm);
    }
}
