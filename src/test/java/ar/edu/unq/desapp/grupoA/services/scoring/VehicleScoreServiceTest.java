package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.VehicleTestFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class VehicleScoreServiceTest extends BaseScoreServiceTest<Vehicle> {

    protected UserModel driver;
    private Vehicle scoringModel;
    @Autowired
    private VehicleScoreService vehicleScoreService;

    public void setUp() {
        this.driver = this.userModelTestFactory.getUser();
        super.setUp();
    }

    @Override
    protected int getUserPoints() {
        return this.scoringModel.getDriverPoints();
    }

    @Override
    protected Vehicle getScoringModel() {
        return this.scoringModel;
    }

    @Override
    protected void createScoringModel() {
        this.scoringModel = new VehicleTestFactory().getVehicle(this.driver);
    }

    @Override
    protected Set<Score> getScoringModelScores() {
        return this.scoringModel.getScores();
    }

    @Override
    protected BaseScoreService<Vehicle> getService() {
        return this.vehicleScoreService;
    }
}
