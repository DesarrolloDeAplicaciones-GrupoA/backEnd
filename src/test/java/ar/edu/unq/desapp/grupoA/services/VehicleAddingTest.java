package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import ar.edu.unq.desapp.grupoA.repositories.VehicleRepository;
import ar.edu.unq.desapp.grupoA.factories.StringUtils;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class VehicleAddingTest extends AbstractServiceTest {

    private String vehicleName;
    private UserModel user;
    @Autowired
    private VehicleAdding vehicleAdding;
    @Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private UserModelTestFactory userModelTestFactory;

    @Before
    public void setUp() {
        this.user = this.getUser();
        this.vehicleName = StringUtils.getName();
        this.vehicleAdding.createVehicle(this.user, this.vehicleName, 4);
    }

    @Test
    public void addingVehicleToUserTest() {
        assertEquals(this.user.getVehicle().getBrand(), this.vehicleName);
        assertEquals(this.user.getVehicle().getCapacity(), 4);
        assertEquals(this.user.getVehicle().getScores().size(), 0);
    }

    @Test
    public void vehicleHasADriver() {
        assertEquals(this.user.getVehicle().getDriver(), user);
    }

    @Test
    public void hasOneMoreVehicle() {
        assertEquals(1, this.vehicleRepository.count());
    }

    @Test
    public void useHasHisVehicle() {

        UserModel user = this.userModelRepository.findById(this.user.getId());
        assertNotNull(user.getVehicle());
    }

    private UserModel getUser() {
        return this.userModelTestFactory.getUser();
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
