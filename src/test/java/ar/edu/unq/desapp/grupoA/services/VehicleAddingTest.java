package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import ar.edu.unq.desapp.grupoA.repositories.VehicleRepository;
import ar.edu.unq.desapp.grupoA.testUtis.factories.StringUtils;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleAddingTest extends AbstractServiceTest {


    private UserModel user;
    @Autowired
    private VehicleAdding vehicleAdding;
    @Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    private String vehicleName;

    @Before
    public void setUp() {
        this.user = this.getUser();
        this.userModelRepository.save(this.user);
        this.vehicleName = StringUtils.getName();
        this.vehicleAdding.createVehicle(user, this.vehicleName, 4);
    }

    @Test
    public void addingVehicleToUserTest() {
        Assert.assertEquals(this.user.getVehicle().getBrand(), this.vehicleName);
        Assert.assertEquals(this.user.getVehicle().getCapacity(), 4);
        Assert.assertEquals(this.user.getVehicle().getScores().size(), 0);
    }

    @Test
    public void vehicleHasADriver() {
        Assert.assertEquals(this.user.getVehicle().getDriver(), user);
    }

    private UserModel getUser() {
        return new UserModelTestFactory().getUser();
    }

    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public void setUserModelRepository(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    public UserModelRepository getUserModelRepository() {
        return userModelRepository;
    }

    public void setVehicleAdding(VehicleAdding vehicleAdding) {
        this.vehicleAdding = vehicleAdding;
    }

    public VehicleAdding getVehicleAdding() {
        return vehicleAdding;
    }
}
