package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.repositories.VehicleRepository;

public class VehicleAdding {

    private VehicleRepository repository;

    public void createVehicle(UserModel user, String brand, int capacity) {
        user.setVehicle(new Vehicle(brand, capacity, user));
    }

    public void setRepository(VehicleRepository repository) {
        this.repository = repository;
    }

    public VehicleRepository getRepository() {
        return repository;
    }
}
