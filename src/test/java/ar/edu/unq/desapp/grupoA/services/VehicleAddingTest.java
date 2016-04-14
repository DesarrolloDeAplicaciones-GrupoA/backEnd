package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleAddingTest {
    private UserModel user;
    private VehicleAdding vehicleAdding;

    @Before
    public void setUp() {
        this.user = new UserModel("Foo Bar", "foobar@sample.com");
        this.vehicleAdding = new VehicleAdding();
        this.vehicleAdding.createVehicle(user, "Ford", 4);
    }

    @Test
    public void addingVehicleToUserTest() {
        Assert.assertEquals(this.user.getVehicle().getBrand(), "Ford");
        Assert.assertEquals(this.user.getVehicle().getCapacity(), 4);
        Assert.assertEquals(this.user.getVehicle().getScores().size(), 0);
    }

    @Test
    public void vehicleHasADriver() {
        Assert.assertEquals(this.user.getVehicle().getDriver(), user);
    }

}
