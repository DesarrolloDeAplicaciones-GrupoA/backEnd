package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;

public class VehicleAdding {

    public void createVehicle(UserModel user, String brand, int capacity) {
        user.setVehicle(new Vehicle(brand, capacity, user));
    }

}
