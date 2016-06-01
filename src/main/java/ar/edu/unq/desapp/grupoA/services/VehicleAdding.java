package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("vehicleAdding")
public class VehicleAdding {

    @Autowired
    private VehicleRepository repository;

    @Transactional
    public Vehicle createVehicle(UserModel user, String brand, int capacity) {
        Vehicle vehicle = new Vehicle(brand, capacity, user);
        user.setVehicle(vehicle);
        repository.save(vehicle);
        return vehicle;
    }

    @Transactional
    public Vehicle get(Integer id) {
        return this.repository.findById(id);
    }

    @Transactional
    public void createExampleVehicle() {
        Vehicle vehicleOne = new Vehicle("Ford",5,null);
        Vehicle vehicleTwo = new Vehicle("Fiat",3,null);
        repository.save(vehicleOne);
        repository.save(vehicleTwo);
    }
}
