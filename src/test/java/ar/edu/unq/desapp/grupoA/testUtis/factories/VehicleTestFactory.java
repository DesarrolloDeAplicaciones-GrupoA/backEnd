package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;

public class VehicleTestFactory {

    public Vehicle getVehicle(UserModel drive) {
        return new Vehicle("Toyota", 4, drive);
    }
}
