package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicleTestFactory")
public class VehicleTestFactory {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicle(UserModel drive) {
        Vehicle vehicle = new Vehicle("Toyota", 4, drive);
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
